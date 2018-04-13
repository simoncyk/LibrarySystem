package com.web.dao;

import com.web.common.JdbcUtils;
import com.web.common.TXQueryRunner;
import com.web.prjo.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simonk on 2018/03/28.
 */
public class libsysdao {

    QueryRunner qr= new TXQueryRunner();
    public manger login (String mangename , String pwd ) throws Exception{
        try {

            String sql="select *from libsys_manager as lm inner join libsys_purview as lp on lm.id=lp.id where name =? and PWD=?";
            Object[] parmas ={mangename,pwd};
            qr.query(sql ,new BeanHandler<manger>(manger.class),parmas);

            return  qr.query(sql ,new BeanHandler<manger>(manger.class),parmas);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }


    public List<BookMsg> bookmsg ( ) throws Exception{
        try {

            String sql="select *from v_cbc_bookmsg order by  id desc";
            return qr.query(sql ,new BeanListHandler<BookMsg>(BookMsg.class));
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }
    public List<BookMsg> BookBorrowSortMsg ( ) throws Exception{
        try {

            StringBuffer sql=new StringBuffer();
            sql.append("SELECT Count(bookname) AS degree,bookname,price,barcode,");
            sql.append("author,typename,pubname,id,bookcasename,typeid,translator,ISBN,page,bookcase ");
            sql.append("FROM  v_cbc_BookBorrowSortMsg GROUP BY bookname,price ORDER BY  degree DESC");

            return qr.query(sql.toString() ,new BeanListHandler<BookMsg>(BookMsg.class));
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }


    public List<booktype> booktype ( )throws Exception{
        try {

            String sql="select *from libsys_booktype";
            return qr.query(sql ,new BeanListHandler<booktype>(booktype.class));
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }
    public List<bookcase> bookcase ( ) throws Exception{
        try {

            String sql="select *from libsys_bookcase";
            return qr.query(sql ,new BeanListHandler<bookcase>(bookcase.class));
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }
    }
    public List<publishing> publishing ( ) throws Exception{
        try {

            String sql="select *from libsys_publishing";
            return qr.query(sql ,new BeanListHandler<publishing>(publishing.class));
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public void bookadd ( BookMsg bm ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("INSERT INTO `libsys_bookinfo` ( `barcode`, `bookname`, `typeid`, `author`, `translator`, `ISBN`, `price` ");
            sql.append(" , `page`, `bookcase`, `operator`, `del`, `inTime`) VALUES ( ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,NOW());");
            Object[] parmas ={bm.getBarcode(),bm.getBookname(),bm.getTypeid(),bm.getAuthor(),bm.getTranslator(),bm.getISBN(),bm.getPrice(),bm.getPage(),bm.getBookcase(), bm.getOperator(),0};
            qr.update(sql.toString(),parmas);

        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public booktype VbookTypeModify ( String ID ) throws Exception {
        try {
            String sql= "select *from libsys_booktype where id=? ";
            return qr.query(sql.toString(),new BeanHandler<booktype>(booktype.class),ID);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }
    public void bookTypeModify (booktype bt ) throws Exception {
        try {
            String sql= "UPDATE libsys_booktype set typename=? ,days=? where id=? ";
            Object[] parmas={bt.getTypename(),bt.getDays(),bt.getId()};
            qr.update(sql,parmas);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }
    public void bookTypeAdd (booktype bt ) throws Exception {
        try {
            String sql= "INSERT INTO libsys_booktype (typename ,days ) VALUES(?,?)";
            Object[] parmas={bt.getTypename(),bt.getDays()};
            qr.update(sql,parmas);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }
    public void bookTypeDel ( String ID ) throws Exception {
        try {
            String sql= "DELETE  FROM  libsys_booktype WHERE id=?";
            qr.update(sql,ID);
        }catch ( Exception e){
            throw  new RuntimeException(e.toString());
        }
    }

    public BookMsg bookDetail (String ID ) throws Exception{
        try {

            String sql="select *from v_cbc_bookmsg where id=?";
            return qr.query(sql ,new BeanHandler<BookMsg>(BookMsg.class),ID);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }
    public BookMsg VbookModify (String ID ) throws Exception{
        try {

            String sql="select *from v_cbc_bookmsg where id=?";
            return qr.query(sql ,new BeanHandler<BookMsg>(BookMsg.class),ID);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }
    }

    public void bookModify ( BookMsg bm ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("UPDATE libsys_bookinfo set barcode=?, bookname=?, typeid=?, author=?, translator=?, ISBN=?, price=? ");
            sql.append(" , page=?, bookcase=?, operator=? where id=?");
            Object[] parmas ={bm.getBarcode(),bm.getBookname(),bm.getTypeid(),bm.getAuthor(),bm.getTranslator(),bm.getISBN(),bm.getPrice(),bm.getPage(),bm.getBookcase(), bm.getOperator(),bm.getId()};
            qr.update(sql.toString(),parmas);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public void bookDel ( String ID ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("DELETE FROM libsys_bookinfo WHERE  id= ? ");
            qr.update(sql.toString(),ID);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }
    public List<Readermsg> readermsg ( ) throws Exception{
        try {
            String sql="select *from v_cbc_readermsg order by  id desc";
            return qr.query(sql ,new BeanListHandler<Readermsg>(Readermsg.class));
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public void readerAdd ( Readermsg rm ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("INSERT INTO libsys_reader(name,sex,barcode,vocation,birthday,paperType,paperNO,tel,operator,remark ,typeid,email,createDate)");
            sql.append(" VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?,?, NOW());");
            Object[] parmas ={rm.getName(),rm.getSex(),rm.getBarcode(),rm.getVocation(),rm.getBirthday(),rm.getPaperType(),
                    rm.getPaperNO(),rm.getTel(),rm.getOperator(),rm.getRemark(),rm.getTypeid(),rm.getEmail() };
            qr.update(sql.toString(),parmas);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public Readermsg VreaderModify (String ID ) throws Exception{
        try {

            String sql="select *from v_cbc_readermsg where id=?";
            return qr.query(sql ,new BeanHandler<Readermsg>(Readermsg.class),ID);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }
    }

    public void readerModify ( Readermsg rm ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("UPDATE libsys_reader SET name=?,sex=?,barcode=?,vocation=?,birthday=?,paperType=?,paperNO=?,tel=?,operator=?,remark=? ,typeid=?,email=? where id=?");
            Object[] parmas ={rm.getName(),rm.getSex(),rm.getBarcode(),rm.getVocation(),rm.getBirthday(),rm.getPaperType(),
                    rm.getPaperNO(),rm.getTel(),rm.getOperator(),rm.getRemark(),rm.getTypeid(),rm.getEmail() ,rm.getId()};
            qr.update(sql.toString(),parmas);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public Readermsg readerDetail (String ID ) throws Exception{
        try {

            String sql="select *from v_cbc_readermsg where id=?";
            return qr.query(sql ,new BeanHandler<Readermsg>(Readermsg.class),ID);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }
    }
    public void readerDel ( String ID ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("DELETE FROM libsys_reader WHERE  id= ? ");
            qr.update(sql.toString(),ID);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public List<ReaderType> readerType ( )throws Exception{
        try {

            String sql="select *from libsys_readertype";
            return qr.query(sql ,new BeanListHandler<ReaderType>(ReaderType.class));
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public ReaderType VreaderTypeModify (String ID ) throws Exception{
        try {

            String sql="select *from libsys_readertype where id=?";
            return qr.query(sql ,new BeanHandler<ReaderType>(ReaderType.class),ID);
        }catch ( Exception e){
            throw  new RuntimeException(e.toString());
        }
    }

    public void readerTypeAdd ( ReaderType rt ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("INSERT INTO libsys_readertype (name,number)VALUES ( ?,?)");
            Object[] parmas ={rt.getName(),rt.getNumber()};
            qr.update(sql.toString(),parmas);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public void readerTypeModify ( ReaderType rt ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("UPDATE libsys_readertype SET name=?,number=? where id=?");
            Object[] parmas ={rt.getName(),rt.getNumber(),rt.getId()};
            qr.update(sql.toString(),parmas);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public void readerTypeDel ( String ID ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("DELETE FROM libsys_readerType WHERE  id= ? ");
            qr.update(sql.toString(),ID);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public manger vmodifypwd ( String ID ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("select *from libsys_manager  WHERE  id= ?");
            return qr.query(sql.toString(),new  BeanHandler<manger>(manger.class) ,ID);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public void modifypwd ( manger mg ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("UPDATE libsys_manager SET name=?,PWD=? where id=?");
            Object[] parmas ={mg.getName(),mg.getPWD(),mg.getId()};
            qr.update(sql.toString(),parmas);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public parameter parameter ( ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("select  * from libsys_parameter  limit 1 ");
            return qr.query(sql.toString(),new  BeanHandler<parameter>(parameter.class) );
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }


    public void parametermodify ( parameter pr ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("UPDATE libsys_parameter SET cost=?,validity=? where id=?");
            Object[] parmas ={pr.getCost(),pr.getValidity(),pr.getId()};
            qr.update(sql.toString(),parmas);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }


    public List<manger> vmanager ( ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("select  * from v_cbc_managermsg ");
            return qr.query(sql.toString(),new BeanListHandler<manger>(manger.class) );
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }


    public manger managermodquery ( String id ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("select *from v_cbc_managermsg where id=?");
            return qr.query(sql.toString(),new BeanHandler<manger>(manger.class),id );
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public void managerModify ( manger mg ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("UPDATE libsys_purview SET sysset=?,readerset=?,bookset=?,borrowback=?,sysquery=? where id=?");
            Object[] parmas ={mg.getSysset(),mg.getReaderset(),mg.getBookset(),mg.getBorrowback(),mg.getSysquery(),mg.getId()};
             qr.update(sql.toString(),parmas);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public void managerDel ( String id ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("DELETE FROM libsys_manager WHERE id=?");
           qr.update(sql.toString(),id );
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public int managerAdd ( manger mr ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("INSERT INTO libsys_manager (name,PWD,limits)VALUES ( ?,?,0)");
            Object[] parmas ={mr.getName(),mr.getPWD()};
            Number num =(Number) qr.insert(sql.toString(),new ScalarHandler(),parmas);
             return  num.intValue();
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }
    public void managersysAdd ( int mangerid ) throws Exception {
        try {
            StringBuilder sql= new StringBuilder();
            sql.append("INSERT INTO libsys_purview VALUES (?,0,0,0,0,0)");
            qr.update(sql.toString(),mangerid );
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }


    public library vlibrary ( ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("select * from libsys_library limit 1");
            return qr.query(sql.toString(),new BeanHandler<library>(library.class) );
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public void libraryModify ( library lib ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("UPDATE libsys_library  set libraryname=?,curator=?,tel=?,address=?,email=?,url=?,createDate=?,introduce=? where id=?");
            Object[] parmas ={lib.getLibraryname(),lib.getCurator(),lib.getTel(),lib.getAddress(),lib.getEmail(),lib.getUrl(),lib.getCreateDate(),lib.getIntroduce(),lib.getId()};
            qr.update(sql.toString(),parmas);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public List<Bookbrrownmsg> Bremind ( ) throws Exception {

         String sql ="select *from v_cbc_borrowmsg where backTime<=adddate(curdate(), '+7 days') AND ifback =0";

        return qr.query(sql,new BeanListHandler<Bookbrrownmsg>(Bookbrrownmsg.class) );
    }

    public List<Bookbrrownmsg> borrowQuery (int type, String selectType, String selectkey,String sdate, String edate ) throws Exception {
        StringBuilder sql= new StringBuilder();
        List<Object> parmas = new ArrayList<Object>()  ;
        sql.append("select *from v_cbc_borrowmsg where 1=1 ");
        if (type ==1 ){
            sql.append("and ").append(selectType).append(" like ?");
            parmas.add("%"+selectkey+"%");
        }
        if (type ==2 ){
            sql.append("and (borrowTime>=? and borrowTime <= ?)");
            parmas.add(sdate);
            parmas.add(edate);
        }
        if(type ==3){
            sql.append("and ").append(selectType).append(" like ? ");
            sql.append("and (borrowTime>=? and borrowTime <= ?)");
            parmas.add("%"+selectkey+"%");
            parmas.add(sdate);
            parmas.add(edate);
        }

        return qr.query(sql.toString(),new BeanListHandler<Bookbrrownmsg>(Bookbrrownmsg.class) ,parmas.toArray());
    }

    public Readermsg readermsg (String readerbarcode ) throws Exception{
        try {

            String sql="select *from v_cbc_readermsg where barcode=?";
            return qr.query(sql ,new BeanHandler<Readermsg>(Readermsg.class),readerbarcode);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }
    }
    public List<Bookbrrownmsg> bookRenewQuery ( String readerbarcode ) throws Exception {
        try {

            String sql ="select *from v_cbc_borrowmsg where  readerbarcode=? and ifback =0";
            return qr.query(sql,new BeanListHandler<Bookbrrownmsg>(Bookbrrownmsg.class) ,readerbarcode);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }



    public void bookrenew ( String id ) throws Exception {
        try {

            StringBuilder sql= new StringBuilder();
            sql.append("UPDATE libsys_borrow set backTime=date_add(backTime, interval 1 MONTH) where id=?");
            qr.update(sql.toString(),id);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public List<BookMsg> bookQuery ( String QueryType,String key) throws Exception{
        try {

            String sql="select *from v_cbc_bookmsg where "+QueryType+"=?";
            return qr.query(sql ,new BeanListHandler<BookMsg>(BookMsg.class),key);
        }catch ( Exception e){

            throw  new RuntimeException(e.toString());
        }

    }

    public void bookCaseAdd ( String name ) throws Exception {
        try {
            StringBuilder sql= new StringBuilder();
            sql.append("INSERT INTO libsys_bookcase (name) VALUES(?)");
            qr.update(sql.toString(),name);
        }catch ( Exception e){
            throw  new RuntimeException(e.toString());
        }

    }

    public bookcase bookCaseModifyQuery ( String id ) throws Exception {
        try {
            StringBuilder sql= new StringBuilder();
            sql.append("select *from  libsys_bookcase where id=?");
            return qr.query(sql.toString() ,new BeanHandler<bookcase>(bookcase.class),id);
        }catch ( Exception e){
            throw  new RuntimeException(e.toString());
        }

    }

    public void bookCaseModify (String id, String name ) throws Exception {
        try {
            StringBuilder sql= new StringBuilder();
            sql.append("UPDATE libsys_bookcase SET name=? where id=? ");
            qr.update(sql.toString(),name,id);
        }catch ( Exception e){
            throw  new RuntimeException(e.toString());
        }

    }

    public void bookCaseDel (String id ) throws Exception {
        try {
            StringBuilder sql= new StringBuilder();
            sql.append("DELETE FROM libsys_bookcase  where id=? ");
            qr.update(sql.toString(),id);
        }catch ( Exception e){
            throw  new RuntimeException(e.toString());
        }

    }


    public void bookback (String id ) throws Exception {
        try {
            StringBuilder sql= new StringBuilder();
            sql.append("UPDATE libsys_borrow set ifback=1 where id=? ");
            qr.update(sql.toString(),id);
        }catch ( Exception e){
            throw  new RuntimeException(e.toString());
        }

    }
    public void bookbackmsg (String bookid ,String readerid ,String operator ) throws Exception {
        try {
            StringBuilder sql= new StringBuilder();
            sql.append("INSERT INTO libsys_giveback(bookid,readerid,operator,backTime) VALUES(?,?,?,NOW()) ");
            qr.update(sql.toString(),bookid,readerid,operator);
        }catch ( Exception e){
            throw  new RuntimeException(e.toString());
        }

    }
    public int borrowNumber ( String readerbarcode ) throws Exception {

        try {
            String sql ="select count(readerbarcode) as count from v_cbc_borrowmsg where  readerbarcode=? and ifback =0";
          Number num =  (Number)qr.query(sql, new ScalarHandler() ,readerbarcode);
            return  num.intValue();
        }catch (Exception e ){

            throw  new RuntimeException(e.toString());
        }

    }


    public int getbookid ( String addtype, String inputkey ) throws Exception {

        try {
            String sql ="SELECT id from  libsys_bookinfo WHERE "+addtype+"=?";
            Number num =  (Number)qr.query(sql, new ScalarHandler() ,inputkey);
            int i=0;
            if (num!=null){
                i= num.intValue();
            }
            return  i;
        }catch (Exception e ){

            throw  new RuntimeException(e.toString());
        }

    }


    public void addreaderborrowmsg (int bookid ,String readerid ,String operator ) throws Exception {
        try {
            StringBuilder sql= new StringBuilder();
            sql.append("INSERT INTO libsys_borrow(bookid,readerid,operator,borrowTime,backTime,ifback) VALUES(?,?,?,NOW(),date_add(NOW(), interval 1 MONTH),0)");
            qr.update(sql.toString(),bookid,readerid,operator);
        }catch ( Exception e){
            throw  new RuntimeException(e.toString());
        }

    }

}
