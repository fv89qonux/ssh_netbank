<%@ page language="java" contentType="text/html;" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>��ӭ��¼��������ϵͳ</title>
    <script type="text/javascript">

        function login() {
        	var hidden = document.getElementById("hidden").value;
        	if(document.getElementById("username"+hidden).value == "") {
        		alert("�û�������Ϊ��!");
        		return false;
        	} else if(document.getElementById("password"+hidden).value == "") {
        		alert("���벻��Ϊ�գ�");
        		return false;
        	} else {
        		return true;
        	}
        }
        function adminlogin(){
        	document.getElementById("username1").style.display="none";
        	document.getElementById("password1").style.display="none";
        	document.getElementById("username2").style.display="block";
        	document.getElementById("password2").style.display="block";
        	document.myform.action="admin/login"
        }
        function init() {
        	document.getElementById("username1").style.diaplay = "block";
        	document.getElementById("password1").style.display = "block";
        	document.getElementById("username2").style.display = "none";
        	document.getElementById("password2").style.display = "none";
        	document.myform.action = "user/user_login";
        }
        function change() {
        	var select = document.myform.type.value;
        	//alert(select);
        	if(select == "0") {
        		var username2 = document.getElementById("username2").value;
        		var password2 = document.getElementById("password2").value;
        		init();
        		document.getElementById("username1").value = username2;
        		document.getElementById("password1").value = password2;
        	}
        	if(select == "1") {
        		var username1 = document.getElementById("username1").value;
        		var password1 = document.getElementById("password1").value;
        		adminlogin();
        		document.getElementById("username2").value = username1;
        		document.getElementById("password2").value = password1;
        	}
        }
    </script>
</head>
<body onload="init()" style="background-color: #5BD0D9">
    <div align="center" style="padding-top: 250px">
        <h2>��ӭ��¼��������ϵͳ</h2>
    </div>
    <div align="center" style="margin-top: 50px">
        <form action="user/user_login" method="post" name="myform" onsubmit="return login()">
            <table width="300" border="0" class="table">
                <tbody>
                    <tr height="30px">
                        <td>�û���:</td>
                        <td>
                            <input id="username1" type="text" name="account.username">
                            <input id="username2" type="text" name="admin.username">    
                        </td>
                    </tr>
                    <tr height="30px">
                        <td>�ܡ���:</td>
                        <td>
                            <input id="password1" type="password" name="account.password">
                            <input id="password2" type="password" name="admin.password">                            
                        </td>
                    </tr>
                    <tr height="30px">
                        <td>�ࡡ��:</td>
                        <td>
                            <input type="radio" name="type" value="0" onclick="change()" checked>�ͻ� &nbsp;&nbsp;&nbsp;
                            <input type="radio" name="type" value="1" onclick="change()">����Ա
                            <!-- 
                            <select name="type" onchange="change()">
                                <option value="0" selected>�͡���</option>
                                <option value="1">����Ա</option>
                            </select>
                             -->
                        </td>
                    </tr>
                    <tr height="40px">
                        <td></td>
                        <td>
                            <input type="submit" id="login" value="�ǡ�¼">
                            <input type="hidden" id="hidden">
                        </td>
                    </tr>
                </tbody>
            </table>
            <s:fielderror fieldName="username" cssStyle="color:red" />
            <s:fielderror fieldName="password" cssStyle="color:red" />
        </form>
    </div> 
</body>
</html>