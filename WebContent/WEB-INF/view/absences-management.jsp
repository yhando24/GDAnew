
<%@ include file="/Resources/inc/header.jsp"%>
<title>Absences Management</title>
</head>

<body>
    <%@ include file="/Resources/inc/navbar.jsp"%>
    <c:choose>
        <c:when test="${user.function.name == 'admin'}">
            <%@ include file="/Resources/inc/sidebar-admin.jsp"%>
        </c:when>
        <c:when test="${user.function.name == 'manager'}">
            en attente du link
        </c:when>
        <c:when test="${user.function.name == 'user'}">
            <%@ include file="/Resources/inc/sidebar-user.jsp"%>
        </c:when>
    </c:choose>

    <div class="container">
        <h1>Gestion des absences</h1>
        <c:if test="${!empty user}">
            <table style="border: 1px solid">
                <tr style="border: 1px solid">
                    <th>Date debut</th>
                    <th>date de fin</th>
                    <th>type</th>
                    <th>statut</th>
                    <th>Action</th>
                </tr>

                <c:forEach items="${user.absences}" var="abs" varStatus="status">
                    <tr style="border: 1px solid">
                        <td style="border: 1px solid">${abs.startDate}</td>
                        <td style="border: 1px solid"> ${abs.endDate}</td>
                        <td style="border: 1px solid">${abs.absenceType.name}</td>
                        <td style="border: 1px solid">${abs.status.name}</td>
                        <td>
                            <c:choose>
                                <c:when test="${abs.absenceType.name == 'MISSION'}">
                                    <i class="fas fa-eye"></i>
                                    
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${abs.status.name == 'INITIALE'}">
                                            <a href="<c:url value ="/AbsencesManagement?action=updateAbsence&nbr=${abs.id}"/>"> 
                                            	<i class="fas fa-pencil-alt"></i>
                    						</a>
                    						<i class="fas fa-trash-alt"></i>
                                        </c:when>
                                        <c:when test="${abs.status.name == 'EN_ATTENTE_VALIDATION'}">
                                            <i class="fas fa-trash-alt"></i>
                                        </c:when>
                                        <c:when test="${abs.status.name == 'VALIDEE'}">
                                           <i class="fas fa-trash-alt"></i>
                                        </c:when>
                                        <c:when test="${abs.status.name == 'REJETEE'}">
                                            rejete
                                        </c:when>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div>
                <div>
                    Demander une absence
                    <a href="<c:url value ="/AbsencesManagement?action=addAbsence"/>"> <i class="far fa-plus-square"></i>
                    </a>
                </div>
          
                <div>
                    Soldes des compteurs:
                    CP: ..... jours.
                    RTT: .... jours.
                </div>
            </div>
        </c:if>
    </div>
    <%@ include file="/Resources/inc/footer.jsp"%>