<%@ page language="java" contentType="text/html;" pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <link href="css/admin.css" type="text/css" rel="stylesheet" >
</head>
<body>
    <table width="170" height="100%" cellspacing="0" cellpadding="0" background="images/menu_bg.jpg" border="0">
        <tr>
            <td valign="top" align="center">
                <table width="150" cellpadding="0" cellspacing="0" border="0">
                    <tr height="25">
                        <td style="padding-left: 30px" background="images/menu_bt.jpg">
                            <a style="font-size: 15px" class="menuParent" onclick="expend(1)" href="javascript:void(0);">操作菜单</a>
                        </td>
                    </tr>
                    <tr height="6">
                        <td></td>
                    </tr>
                </table>
                <table id="child0" width="150" cellpadding="0" cellspacing="0" border="0">
                    <tr height="20">
                        <td width="30" align="center">
                           <img width="9" height="9" src="images/menu_icon.gif"> 
                        </td>
                        <td>
                            <a id="menuChild" style="font-size: 13px" href="/ssh_bank/deposit.jsp" target="main">存款</a>
                        </td>
                    </tr>
                    <tr height="20">
                        <td width="30" align="center">
                           <img width="9" height="9" src="images/menu_icon.gif"> 
                        </td>
                        <td>
                            <a id="menuChild" style="font-size: 13px" href="/ssh_bank/withdraw.jsp" target="main">取款</a>
                        </td>
                    </tr>
                    <tr height="20">
                        <td width="30" align="center">
                           <img width="9" height="9" src="images/menu_icon.gif"> 
                        </td>
                        <td>
                            <a id="menuChild" style="font-size: 13px" href="/ssh_bank/transfer.jsp" target="main">转账</a>
                        </td>
                    </tr>
                    <tr height="20">
                        <td width="30" align="center">
                           <img width="9" height="9" src="images/menu_icon.gif"> 
                        </td>
                        <td>
                            <a id="menuChild" style="font-size: 13px" href="/ssh_bank/transaction/list?pager.curPage=1" target="main">查询交易记录</a>
                        </td>
                    </tr>
                    <tr height="20">
                        <td width="30" align="center">
                           <img width="9" height="9" src="images/menu_icon.gif"> 
                        </td>
                        <td>
                            <a id="menuChild" style="font-size: 13px" href="/ssh_bank/infomation.jsp" target="main">查看个人信息</a>
                        </td>
                    </tr>
                    <tr height="20">
                        <td width="30" align="center">
                           <img width="9" height="9" src="images/menu_icon.gif"> 
                        </td>
                        <td> 
                            <a id="menuChild" style="font-size: 13px" href="/ssh_bank/modify.jsp" target="main">修改个人信息</a>
                        </td>
                    </tr>
                    <tr height="20">
                        <td width="30" align="center">
                           <img width="9" height="9" src="images/menu_icon.gif"> 
                        </td>
                        <td>
                            <a id="menuChild" style="font-size: 13px" href="/ssh_bank/changepwd.jsp" target="main">修改密码</a>
                        </td>
                    </tr>
                    <tr height="20">
                        <td width="30" align="center">
                           <img width="9" height="9" src="images/menu_icon.gif"> 
                        </td>
                        <td>
                            <a id="menuChild" style="font-size: 13px" href="/ssh_bank/user/user_logout" target="_top">注销</a>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</body>
</html>