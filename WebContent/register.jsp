<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><a href="login.jsp">用户登录</a>|<a href="register.jsp">用户注册</a></p>
         <s:form action="registerAction" theme="simple">
            <table>
                <tr>
                    <td style="text-align:right">
                        请输入账号
                    </td>
                    <td>
                         <s:textfield name="user.username" label="账号" />
                     </td>
                 </tr>
                 <tr>
                    <td style="text-align:right">
                        请输入密码
                    </td>
                    <td>
                         <s:password name="user.password" label="密码" />
                     </td>
                </tr>
                <tr>
                     <td style="text-align:right">
                         请再次输入密码
                     </td>
                    <td>
                         <s:password name="user.rePwd" label="重复密码" />
                    </td>
                </tr>
               <tr>
                    <td style="text-align:right">
                         <s:submit value="注册" />
                    </td>
                     <td style="text-align:left">
                        <s:reset value="取消"/>
                     </td>
                 </tr>
            </table>
         </s:form>
        <s:fielderror cssStyle="color:red"/>
</body>
</html>