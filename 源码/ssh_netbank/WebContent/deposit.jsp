<%@ page language="java" contentType="text/html;" pageEncoding="gb2312"%>
<% 
   java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(  
     "yyyy-MM-dd HH:mm:ss");  
   java.util.Date currentTime = new java.util.Date();  
   String time = simpleDateFormat.format(currentTime).toString();  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>���</title>
    <script type="text/javascript">
    
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
        function deposit() {
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
    				return confirm("ȷ�ϴ����?");
    			}
        	} else {
        		document.getElementById("errormoney").innerHTML="����Ϊ�գ�";
        		return false;
        	}
        }
        
    </script>
</head>
<body onload="disptime()">
    <form action="/ssh_bank/transaction/deposit" name="myform" method="post" onsubmit="return deposit()">
        <div align="center">
            <table>
                <tbody>
                    <tr>
                    <td>���ʱ�䣺</td>
                    <td width="360" height="30">
                        <input type="text" name="log.datetime" id="datetime" />
                    </td>
                </tr>
                <tr>
                    <td>����</td>
                    <td width="360" height="30">
                        <input type="text" name="log.tr_money" id="tr_money" />
                        <span id="errormoney" style="color:red;"></span>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td width="360" height="30">
                        <input type="submit" value="���" />
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </form>
</body>
</html>