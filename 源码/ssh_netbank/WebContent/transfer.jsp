<%@ page language="java" contentType="text/html;" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>���</title>
    <script type="text/javascript">
    
        //��ȡʱ�� 
	    function disptime(){
	    	var now=new Date();
	    	
	    	var year=now.getFullYear();
	    	var month=now.getMonth()+1;
	    	var date=now.getDate();
	    	var hour=now.getHours();
	    	var minute=now.getMinutes();
	    	var second =now.getSeconds();
	    		document.getElementById("datetime").value=year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
	    		//year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
	    		setTimeout("disptime()", 1000);
	    	}    
    
        //�ж��û�����Ĵ�����Ƿ����
        function transfer() {
        	var money = document.getElementById("tr_money").value;
        	//alert(money.length);
        	if(money.length>0) {
        		if(!(money.search(/^[\+\-]?\d+\.?\d*$/)==0)) {
    				document.getElementById("errormoney").innerHTML="���зǷ��ַ�!";
    				return false;
    			}else {
    				if(parseFloat(money)==0) {
    					document.getElementById("errormoney").innerHTML="���������0!";
    					return false;
    				}
    				return confirm("ȷ��Ҫת���� ");
    			}
        	} else {
        		document.getElementById("errormoney").innerHTML="����Ϊ�գ�";
        		return false;
        	}
        }
        
    </script>
</head>
<body onload="disptime()">
    <form action="/ssh_bank/transaction/transfer" name="myform" method="post" onsubmit="return transfer()">
        <div align="center">
            <table>
                <tbody>
                    <tr>
                    <td>ת��ʱ�䣺</td>
                    <td width="360" height="30">
                        <input type="text" name="log.datetime" id="datetime" />
                    </td>
                </tr>
                <tr>
                    <td>�Է��˻���</td>
                    <td width="360" height="30">
                        <input type="text" name="log.otherid" id="otherid" />
                        <span id="errorotherid" style="color:red;"></span>
                    </td>
                </tr>
                <tr>
                    <td>ת�˽�</td>
                    <td width="360" height="30">
                        <input type="text" name="log.tr_money" id="tr_money" />
                        <span id="errortr_money" style="color:red;"></span>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td width="360" height="30">
                        <input type="submit" value="ת��" />
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div>
            <s:fielderror name="log.tr_money" style="color:red;"></s:fielderror>
        </div>
    </form>
</body>
</html>