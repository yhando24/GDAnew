<%@ include file="/Resources/inc/header.jsp" %>
<title>Insert title here</title>
</head>
<body>
<%@ include file="/Resources/inc/navbar.jsp"%>
<%-- 
<%@ include file="inc/sidebar-user.jsp"%> --%>
	<div style="padding-left: 30%; padding-top: 6%">
<h1>plop</h1>
		<%-- <c:if test="${!empty user}">
			<table>
				<c:forEach items="${user.absenses}" var="abs" varStatus="status">

					<tr>
						<th><c:out value="${ p.nom }" /> <c:out
								value="${ p.prenom }" /> <a
							href="<c:url value ="personne?action=update&personne=${status.index}"/>">
								<button type="button" class="btn btn-outline-warning">update</button>
						</a> <a
							href="<c:url value ="personne?action=delete&personne=${status.index}"/>">
								<button type="button" class="btn btn-outline-danger">delete</button>
						</a></th>
					</tr>
				</c:forEach>
			</table>
		</c:if> --%>
	</div>


<%@ include file="/Resources/inc/footer.jsp" %>