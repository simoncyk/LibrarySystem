package com.web.servlet;

import com.web.common.BaseServlet;
import com.web.prjo.*;
import com.web.services.Services;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by simonk on 2018/03/27.
 */
@WebServlet("/Servlet")
public class Servlet extends BaseServlet {

     Services Services = new Services();
 public  String  login (HttpServletRequest req ,HttpServletResponse reqs ) throws Exception{
     HttpSession session=req.getSession();
     String mangetname =req.getParameter("mamgername");
     String password =req.getParameter("password");
     manger manger =Services.login(mangetname, password);
     if (manger !=null){
         req.getSession().setAttribute("manger",manger);
         return "r:/Servlet?method=BookBorrowSortMsg";
     }else{
         req.setAttribute("msg","名称或密码错误");
         return  "/login.jsp";
     }

 }
    public  String  bookmsg (HttpServletRequest req ,HttpServletResponse reqs ) throws Exception{
        List<BookMsg> bookmsg=Services.bookmsg();
        req.getServletContext().setAttribute("bookmsg",bookmsg);
        return "r:/book.jsp";
    }

    public  String  BookBorrowSortMsg (HttpServletRequest req ,HttpServletResponse reqs ) throws Exception{
            List<BookMsg> BookBorrowSortMsg=Services.BookBorrowSortMsg();
            req.getServletContext().setAttribute("BookBorrowSortMsg",BookBorrowSortMsg);
            return "r:/main.jsp";
    }

    public  String  bookBorrowSort (HttpServletRequest req ,HttpServletResponse reqs ) throws Exception{
        List<BookMsg> BookBorrowSortMsg=Services.BookBorrowSortMsg();
        req.getServletContext().setAttribute("BookBorrowSort",BookBorrowSortMsg);
        return "r:/bookBorrowSort.jsp";
    }

 public  String Vbookadd (HttpServletRequest req ,HttpServletResponse reqs ) throws Exception{

     ServletContext sc =  req.getServletContext();
     sc.setAttribute("booktype",Services.booktype());
     sc.setAttribute("bookcase",Services.bookcase());
     sc.setAttribute("publishing",Services.publishing());
     return "r:/book_add.jsp";
 }

    public  String bookadd (HttpServletRequest req ,HttpServletResponse reqs ) throws Exception{
        BookMsg bm= new BookMsg();
        bm.setBarcode(req.getParameter("barcode") );
        bm.setBookname(req.getParameter("bookName") );
        bm.setTypeid(req.getParameter("typeId") );
        bm.setAuthor(req.getParameter("author") );
        bm.setTranslator(req.getParameter("translator") );
        bm.setISBN(req.getParameter("isbn") );
        bm.setPrice(req.getParameter("price") );
        bm.setPage(req.getParameter("page") );
        bm.setBookcase(req.getParameter("bookcaseid") );
        bm.setOperator(req.getParameter("operator") );
        Services.bookadd(bm );
        req.setAttribute("para",1);
        return "/book_ok.jsp";
    }

    public  String  bookDetail (HttpServletRequest req ,HttpServletResponse reqs ) throws Exception{
      String ID =req.getParameter("ID");
        BookMsg bookDetail=Services.bookDetail(ID);
        req.getServletContext().setAttribute("bookDetail",bookDetail);
        return "r:/book_detail.jsp";
    }
    public  String  VbookModify (HttpServletRequest req ,HttpServletResponse reqs ) throws Exception{
        String ID =req.getParameter("ID");
        BookMsg bookModify=Services.VbookModify(ID);
        ServletContext sc =  req.getServletContext();
        sc.setAttribute("booktype",Services.booktype());
        sc.setAttribute("bookcase",Services.bookcase());
        sc.setAttribute("publishing",Services.publishing());
        sc.setAttribute("bookModify",bookModify);
        return "r:/book_Modify.jsp";
    }
    public  String bookModify (HttpServletRequest req ,HttpServletResponse reqs ) throws Exception{
        BookMsg bm= new BookMsg();
        bm.setId(Integer.parseInt(req.getParameter("ID")));
        bm.setBarcode(req.getParameter("barcode") );
        bm.setBookname(req.getParameter("bookName") );
        bm.setTypeid(req.getParameter("typeId") );
        bm.setAuthor(req.getParameter("author") );
        bm.setTranslator(req.getParameter("translator") );
        bm.setISBN(req.getParameter("isbn") );
        bm.setPrice(req.getParameter("price") );
        bm.setPage(req.getParameter("page") );
        bm.setBookcase(req.getParameter("bookcaseid") );
        bm.setOperator(req.getParameter("operator") );
        Services.bookModify(bm );
        req.setAttribute("para",2);
        return "/book_ok.jsp";
    }
    public String bookDel (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        String ID =  req.getParameter("ID");
        Services.bookDel(ID);
        req.setAttribute("para" ,3);
        return "/book_ok.jsp";
    }

    public String bookType (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        req.getServletContext().setAttribute("booktype",Services.booktype());
     return "r:/bookType.jsp";
    }
    public String VbookTypeModify (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        String ID =  req.getParameter("ID");
        booktype  booktype = Services.VbookTypeModify(ID);
        req.getServletContext().setAttribute("booktype" ,booktype);
        return "r:/bookType_Modify.jsp";
    }
    public String bookTypeModify (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        booktype bt =new booktype();
        String id =req.getParameter("id");
        bt.setId( Integer.parseInt(id));
        bt.setTypename(req.getParameter("typeName"));
        bt.setDays(req.getParameter("days"));
        Services.bookTypeModify(bt);
        req.getServletContext().setAttribute("para",2);
        return "r:/bookType_ok.jsp";
    }

    public String bookTypeAdd (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        booktype bt =new booktype();
        bt.setTypename(req.getParameter("typeName"));
        bt.setDays(req.getParameter("days"));
        Services.bookTypeAdd(bt);
        req.getServletContext().setAttribute("para",1);
        return "r:/bookType_ok.jsp";
    }


    public String bookTypeDel (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        String ID =  req.getParameter("ID");
        Services.bookTypeDel(ID);
        req.getServletContext().setAttribute("para" ,3);
        return "r:/bookType_ok.jsp";
    }

    public  String  readermsg (HttpServletRequest req ,HttpServletResponse reqs ) throws Exception{
        List<Readermsg> readermsg=Services.readermsg();
        req.getServletContext().setAttribute("readermsg",readermsg);
        return "r:/reader.jsp";
    }


    public String Vreaderadd(HttpServletRequest req ,HttpServletResponse reqs)throws Exception{

        req.getServletContext().setAttribute("readerType",Services.readerType());
        return "r:/reader_add.jsp";
    }

    public  String readerAdd (HttpServletRequest req ,HttpServletResponse reqs ) throws Exception{
        Readermsg rm= new Readermsg();
        rm.setBarcode(req.getParameter("barcode") );
        rm.setName (req.getParameter("name") );
        rm.setTypeid(req.getParameter("typeid") );
        rm.setSex(req.getParameter("sex") );
        rm.setVocation(req.getParameter("vocation") );
        rm.setBirthday(req.getParameter("birthday") );
        rm.setPaperType(req.getParameter("paperType") );
        rm.setPaperNO(req.getParameter("paperNO") );
        rm.setTel(req.getParameter("tel") );
        rm.setEmail(req.getParameter("email") );
        rm.setRemark(req.getParameter("remark") );
        rm.setOperator(req.getParameter("operator") );
        Services.readerAdd(rm );
        req.setAttribute("para",1);
        return "/reader_ok.jsp";
    }


    public String VreaderModify(HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        String ID =  req.getParameter("ID");
        Readermsg  readermsg = Services.VreaderModify(ID);
        req.getServletContext().setAttribute("readerType",Services.readerType());
        req.getServletContext().setAttribute("readermsg" ,readermsg);
        return "r:/reader_Modify.jsp";
    }
    public  String readerModify (HttpServletRequest req ,HttpServletResponse reqs ) throws Exception{
        Readermsg rm= new Readermsg();
        rm.setId(req.getParameter("id"));
        rm.setId(req.getParameter("id"));
        rm.setBarcode(req.getParameter("barcode") );
        rm.setName (req.getParameter("name") );
        rm.setTypeid(req.getParameter("typeid") );
        rm.setSex(req.getParameter("sex") );
        rm.setVocation(req.getParameter("vocation") );
        rm.setBirthday(req.getParameter("birthday") );
        rm.setPaperType(req.getParameter("paperType") );
        rm.setPaperNO(req.getParameter("paperNO") );
        rm.setTel(req.getParameter("tel") );
        rm.setEmail(req.getParameter("email") );
        rm.setRemark(req.getParameter("remark") );
        rm.setOperator(req.getParameter("operator") );
        Services.readerModify(rm );
        req.setAttribute("para",2);
        return "/reader_ok.jsp";
    }

    public  String  readerDetail (HttpServletRequest req ,HttpServletResponse reqs ) throws Exception{
        String ID =req.getParameter("ID");
        Readermsg readermsg=Services.readerDetail(ID );
        req.getServletContext().setAttribute("readermsg",readermsg);
        return "r:/reader_detail.jsp";
    }


    public String readerDel (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        String ID =  req.getParameter("ID");
        Services.readerDel(ID);
        req.setAttribute("para" ,3);
        return "/reader_ok.jsp";
    }

    public String readerType (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        req.getServletContext().setAttribute("readerType",Services.readerType());
        return "r:/readerType.jsp";
    }

    public String readerTypeAdd (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        ReaderType rt =new ReaderType();
        rt.setName(req.getParameter("name"));
        rt.setNumber(req.getParameter("number"));
        Services.readerTypeAdd(rt);
        req.setAttribute("para",1);
        return "/readerType_ok.jsp";
    }


    public String VreaderTypeModify (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        String ID =  req.getParameter("ID");
        ReaderType readerType = Services.VreaderTypeModify(ID);
        req.getServletContext().setAttribute("readerType" ,readerType);
        return "r:/readerType_Modify.jsp";
    }

    public String readerTypeModify (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        ReaderType rt =new ReaderType();
        rt.setId(req.getParameter("id"));
        rt.setName(req.getParameter("name"));
        rt.setNumber(req.getParameter("number"));
        Services.readerTypeModify(rt);
        req.setAttribute("para",2);
        return "/readerType_ok.jsp";
    }
    public String readerTypeDel (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        String ID =  req.getParameter("ID");
        Services.readerTypeDel(ID);
        req.setAttribute("para" ,3);
        return "/readerType_ok.jsp";
    }

    public String vmodifypwd (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        String ID =  req.getParameter("id");
       manger  manger = Services.vmodifypwd(ID);
        req.getServletContext().setAttribute("manger" ,manger);
        return "r:/pwd_Modify.jsp";
    }

    public String modifypwd (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        manger mg =new manger();
        mg.setId(Integer.parseInt(req.getParameter("id")) );
        mg.setName(req.getParameter("name"));
        mg.setPWD(req.getParameter("pwd"));
        Services.modifypwd(mg);
        return "/pwd_ok.jsp";
    }

    public String parameter (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        String ID =  req.getParameter("id");
        parameter  parameter = Services.parameter();
        req.getServletContext().setAttribute("parameter" ,parameter);
        return "r:/parameter_modify.jsp";
    }

    public String parametermodify (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        parameter pr =new parameter();
        pr.setId(req.getParameter("ID"));
        pr.setCost(req.getParameter("cost"));
        pr.setValidity(req.getParameter("validity"));
        Services.parametermodify(pr);
        return "/parameter_ok.jsp";
    }


    public String vmanager (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        req.getServletContext().setAttribute("manger" ,Services.vmanager());
        return "r:/manager.jsp";
    }
    public String managermodquery (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
       String id = req.getParameter("id");
        req.getServletContext().setAttribute("managermod" ,Services.managermodquery(id));
        return "r:/manager_Modify.jsp";
    }

    public String managerModify (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        manger mg =new manger();
        String sysset = req.getParameter("sysset") == null?"0":req.getParameter("sysset");
        String readerset = req.getParameter("readerset")== null?"0":req.getParameter("readerset");
        String bookset = req.getParameter("bookset")== null?"0":req.getParameter("bookset");
        String borrowback = req.getParameter("borrowback")== null?"0":req.getParameter("borrowback");
        String sysquery = req.getParameter("sysquery")== null?"0":req.getParameter("sysquery");
        String id = req.getParameter("id");
        mg.setId(Integer.parseInt(id));
        mg.setBookset(Integer.parseInt(bookset));
        mg.setBorrowback(Integer.parseInt(borrowback));
        mg.setSysquery(Integer.parseInt(sysquery));
        mg.setReaderset(Integer.parseInt(readerset));
        mg.setSysset(Integer.parseInt(sysset));
        Services.managerModify(mg);
        req.setAttribute("para",2);
        return "/manager_ok.jsp";
    }

    public String managerDel (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{

        String id = req.getParameter("id");
        Services.managerDel(id);
        req.setAttribute("para",3);
        return "/manager_ok.jsp";
    }

    public String managerAdd (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        manger mr =new manger();
        mr.setName(req.getParameter("name"));
        mr.setPWD(req.getParameter("pwd"));
        int mangerid = Services.managerAdd(mr);
        Services.managersysAdd(mangerid);
        req.setAttribute("para",1);
        return "/manager_ok.jsp";
    }

    public String vlibrary (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        req.getServletContext().setAttribute("library" ,Services.vlibrary());
        return "r:/library_modify.jsp";
    }

    public String libraryModify (HttpServletRequest req ,HttpServletResponse reqs)throws Exception{
        library lib =new library();
        lib.setId(req.getParameter("ID"));
        lib.setLibraryname(req.getParameter("libraryname"));
        lib.setCurator(req.getParameter("curator"));
        lib.setTel(req.getParameter("tel"));
        lib.setAddress(req.getParameter("address"));
        lib.setEmail(req.getParameter("email"));
        lib.setUrl(req.getParameter("url"));
        lib.setCreateDate(req.getParameter("createDate"));
        lib.setIntroduce(req.getParameter("introduce"));
        Services.libraryModify(lib);
        return "/library_ok.jsp";
    }

    public String Bremind (HttpServletRequest req ,HttpServletResponse reqs)throws Exception {

        req.getServletContext().setAttribute("Bremind" ,Services.Bremind());
        return  "r:/bremind.jsp" ;
    }

    public String borrowQuery (HttpServletRequest req ,HttpServletResponse reqs)throws Exception {
       String[] flag =req.getParameterValues("flag");
       String selectType =req.getParameter("f");
        String selectkey =req.getParameter("key");
       String sdate =req.getParameter("sdate");
       String edate =req.getParameter("edate");
       req.getServletContext().setAttribute("borrowQuery",Services.borrowQuery(flag,selectType,selectkey,sdate,edate));
        return  "r:/borrowQuery.jsp";
    }

    public String bookRenewQuery (HttpServletRequest req ,HttpServletResponse reqs)throws Exception {

        String readerbarcode =req.getParameter("readerbarcode");
        Readermsg readermsg=Services.readermsg(readerbarcode);
        req.getServletContext().setAttribute("readermsg",readermsg);
        req.getServletContext().setAttribute("readerborrowmsg", Services.bookRenewQuery(readerbarcode ));
        return  "r:/bookRenew.jsp";
    }

    public String bookrenew (HttpServletRequest req ,HttpServletResponse reqs)throws Exception {

        String id =req.getParameter("id");
        String readerbarcode =req.getParameter("readerbarcode");
        Readermsg readermsg=Services.readermsg(readerbarcode);
        Services.bookrenew(id);
        req.getServletContext().setAttribute("readermsg",readermsg);
        req.getServletContext().setAttribute("readerborrowmsg", Services.bookRenewQuery(readerbarcode ));
        return  "r:/bookRenew.jsp";
    }


    public  String  bookQuery (HttpServletRequest req ,HttpServletResponse reqs ) throws Exception{
        String QueryType=req.getParameter("f");
        String key =req.getParameter("key");
        List<BookMsg> bookmsg=Services.bookQuery( QueryType ,key);
        req.getServletContext().setAttribute("bookQuery",bookmsg);
        return "r:/bookQuery.jsp";
    }


    public String bookCaseQuery (HttpServletRequest req ,HttpServletResponse reqs)throws Exception {

       req.getServletContext().setAttribute("bookcase",Services.bookcase());
        return  "r:/bookcase.jsp";
    }

    public String bookCaseAdd (HttpServletRequest req ,HttpServletResponse reqs)throws Exception {
        String name =req.getParameter("name");
        Services.bookCaseAdd( name);
        req.setAttribute("para",1);
        return  "/bookcase_ok.jsp";
    }

    public String bookCaseModifyQuery (HttpServletRequest req ,HttpServletResponse reqs)throws Exception {
        String id = req.getParameter("ID");
        req.getServletContext().setAttribute("bookcase",Services.bookCaseModifyQuery(id));

        return  "/bookCase_Modify.jsp";
    }

    public String bookCaseModify (HttpServletRequest req ,HttpServletResponse reqs)throws Exception {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        Services.bookCaseModify(id ,name);
        req.setAttribute("para",2);
        return  "/bookcase_ok.jsp";
    }


    public String bookCaseDel (HttpServletRequest req ,HttpServletResponse reqs)throws Exception {
        String id = req.getParameter("ID");
        Services.bookCaseDel(id);
        req.setAttribute("para",3);
        return  "/bookcase_ok.jsp";
    }


    public String bookbackQuery (HttpServletRequest req ,HttpServletResponse reqs)throws Exception {

        String readerbarcode =req.getParameter("readerbarcode");
        Readermsg readermsg=Services.readermsg(readerbarcode);
        req.getServletContext().setAttribute("readerbackmsg",readermsg);
        req.getServletContext().setAttribute("readerbookbackmsg", Services.bookRenewQuery(readerbarcode ));
        return  "r:/bookBack.jsp";
    }

    public String bookback (HttpServletRequest req ,HttpServletResponse reqs)throws Exception {

        String id =req.getParameter("id");
        String readerbarcode =req.getParameter("readerbarcode");
        String operator =req.getParameter("operator");
        String bookid =req.getParameter("bookid");
        String readerid =req.getParameter("bookid");
        Readermsg readermsg=Services.readermsg(readerbarcode);
        Services.bookback(id);
        Services.bookbackmsg(bookid,bookid,operator);
        req.getServletContext().setAttribute("readerbackmsg",readermsg);
        req.getServletContext().setAttribute("readerbookbackmsg", Services.bookRenewQuery(readerbarcode ));
        return  "r:/bookBack.jsp";
    }
    public String bookborrow (HttpServletRequest req ,HttpServletResponse reqs)throws Exception {

        String readerbarcode =req.getParameter("readerbarcode");
        String addtype =req.getParameter("f");
        String inputkey =req.getParameter("inputkey");
        if ( inputkey==""){
            inputkey="0";
        }
        int bookid =Services.getbookid(addtype,inputkey);
        String operator =req.getParameter("operator");
        String readerid =req.getParameter("readerid");

        if (bookid>0){
            Services.addreaderborrowmsg(bookid,readerid,operator);
        }
        req.getServletContext().setAttribute("borrowreadermsg",Services.readermsg(readerbarcode));
        req.getServletContext().setAttribute("readerborrowbookmsg", Services.bookRenewQuery(readerbarcode ));
        req.getServletContext().setAttribute("borrowNumber", Services.borrowNumber(readerbarcode ));
        return  "r:/bookBorrow.jsp";
    }




}
