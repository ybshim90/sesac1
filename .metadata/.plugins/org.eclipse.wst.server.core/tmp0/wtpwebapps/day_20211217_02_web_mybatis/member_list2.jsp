<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactoryBuilder"%>
<%@page import="java.io.InputStream"%>
<%@page import="org.apache.ibatis.io.Resources"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@page import="member.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>member list</title>
	</head>
	<body>
	
	<table border="3">
		<tr>
			<th>회원번호</th>
			<th>회원이름</th>
			<th>회원전화</th>
		</tr>
			
		
	
<%
SqlSessionFactory sqlSessionFactory = null;

String resource = "mybatis-config.xml";
InputStream inputStream = Resources.getResourceAsStream(resource);
sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

List<MemberVo> list = null;
try (SqlSession ss = sqlSessionFactory.openSession(true)) {
	list = ss.selectList("member.selectAll");
}

for(MemberVo vo:list){
out.println("<tr>");
	out.println("<td>"+vo.getNo()+"</td>");
	out.println("<td>"+vo.getName()+"</td>");
	out.println("<td>"+vo.getTel()+"</td>");
out.println("</tr>");
}

%>

	</table>

	</body>
</html>