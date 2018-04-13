package com.web.services;

import com.web.common.TXQueryRunner;
import com.web.dao.libsysdao;
import com.web.prjo.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

/**
 * Created by simonk on 2018/03/27.
 */
public class Services {

     libsysdao dao = new  libsysdao();
    public manger login (String mangename , String pwd ) throws Exception{

        return dao.login( mangename ,pwd);
    }
    public List<BookMsg> bookmsg ()throws Exception{

        return dao.bookmsg();
    }
    public List<BookMsg> BookBorrowSortMsg ()throws Exception{

        return dao.BookBorrowSortMsg();
    }


    public BookMsg bookDetail ( String ID)throws Exception{

        return dao.bookDetail(ID);
    }
    public BookMsg VbookModify ( String ID)throws Exception{

        return dao.VbookModify(ID);
    }

    public void bookModify (BookMsg bm )throws Exception{

        dao.bookModify(bm);
    }

    public List<booktype> booktype ()throws Exception{

        return dao.booktype();
    }
    public List<bookcase> bookcase () throws Exception{

        return dao.bookcase();
    }
    public List<publishing> publishing () throws Exception{

        return dao.publishing();
    }

    public void bookadd (BookMsg bm )throws Exception{

        dao.bookadd(bm);
    }

    public booktype VbookTypeModify (String ID )throws Exception{

        return dao.VbookTypeModify(ID);
    }

    public void bookTypeModify (booktype bt)throws Exception{

       dao.bookTypeModify(bt);
    }

    public void bookDel (String ID)throws Exception{

        dao.bookDel(ID);
    }

    public void bookTypeAdd (booktype bt)throws Exception{

        dao.bookTypeAdd(bt);
    }
    public void bookTypeDel (String ID)throws Exception{

        dao.bookTypeDel(ID);
    }

    public List<Readermsg> readermsg ()throws Exception{

        return dao.readermsg();
    }

    public void readerAdd (Readermsg rm )throws Exception{

        dao.readerAdd(rm);
    }

    public Readermsg VreaderModify (String ID )throws Exception{

        return dao.VreaderModify(ID);
    }


    public void readerModify (Readermsg rm )throws Exception{

        dao.readerModify(rm);
    }

    public Readermsg readerDetail ( String id)throws Exception{

        return dao.readerDetail(id);
    }

    public void readerDel (String ID)throws Exception{

        dao.readerDel(ID);
    }

    public List<ReaderType> readerType ()throws Exception{

        return dao.readerType();
    }

    public void readerTypeAdd (ReaderType rt )throws Exception{

        dao.readerTypeAdd(rt);
    }

    public ReaderType VreaderTypeModify (String ID )throws Exception{

        return dao.VreaderTypeModify(ID);
    }

    public void readerTypeModify (ReaderType rt )throws Exception{

        dao.readerTypeModify(rt);
    }

    public void readerTypeDel (String ID)throws Exception{

        dao.readerTypeDel(ID);
    }

    public manger vmodifypwd (String ID)throws Exception{

       return dao.vmodifypwd(ID);
    }

    public void modifypwd (manger mg )throws Exception{

        dao.modifypwd(mg);
    }

    public parameter parameter ()throws Exception{

        return dao.parameter();
    }

    public void parametermodify (parameter pr )throws Exception{

        dao.parametermodify(pr);
    }


    public List<manger> vmanager ()throws Exception{

        return dao.vmanager();
    }


    public manger managermodquery ( String id)throws Exception{

        return dao.managermodquery(id);
    }
    public void managerModify (manger mg)throws Exception{

        dao.managerModify(mg);
    }

    public void managerDel ( String id)throws Exception{

        dao.managerDel(id);
    }
    public int managerAdd (manger mr )throws Exception{

       return  dao.managerAdd(mr);
    }

    public void managersysAdd ( int mangerid)throws Exception{

        dao.managersysAdd(mangerid);
    }

    public library vlibrary ()throws Exception{

        return dao.vlibrary();
    }

    public void libraryModify (library lib )throws Exception{

        dao.libraryModify(lib);
    }

    public List<Bookbrrownmsg> Bremind ()throws Exception{

        return dao.Bremind();
    }

    public List<Bookbrrownmsg> borrowQuery (String[] flag, String selectType, String selectkey,String sdate, String edate)throws Exception{
        int type =0;
     if (   flag.length==2){
         type=3;
     }else{

         if(flag[0].equals("a")){
              type=1;
         }else if(flag[0].equals("b")){
             type=2;
         }

     }
      return dao.borrowQuery(type,selectType,selectkey,sdate,edate);

    }
    public Readermsg readermsg ( String readerbarcode)throws Exception{

        return dao.readermsg(readerbarcode);
    }
    public List<Bookbrrownmsg> bookRenewQuery ( String readerbarcode ) throws Exception {
        return  dao.bookRenewQuery(readerbarcode);
    }

    public void bookrenew ( String id ) throws Exception {
         dao.bookrenew(id);
    }


    public List<BookMsg> bookQuery ( String QueryType,String key)throws Exception{

        return dao.bookQuery(QueryType,key);
    }

    public void bookCaseAdd ( String name ) throws Exception {
        dao.bookCaseAdd(name);
    }

    public bookcase bookCaseModifyQuery ( String id ) throws Exception {
       return dao.bookCaseModifyQuery(id);
    }

    public void bookCaseModify (String id , String name ) throws Exception {
        dao.bookCaseModify(id,name);
    }

    public void bookCaseDel (String id  ) throws Exception {
        dao.bookCaseDel(id);
    }


    public void bookback (String id  ) throws Exception {
        dao.bookback(id);
    }
    public void bookbackmsg (String bookid ,String readerid ,String operator   ) throws Exception {
        dao.bookbackmsg(bookid,readerid,operator);
    }

    public int borrowNumber ( String readerbarcode)throws Exception{

        return dao.borrowNumber(readerbarcode);
    }


    public int getbookid ( String addtype, String inputkey)throws Exception{

        return dao.getbookid(addtype,inputkey);
    }

    public void addreaderborrowmsg (int bookid ,String readerid ,String operator   ) throws Exception {
        dao.addreaderborrowmsg(bookid,readerid,operator);
    }


}
