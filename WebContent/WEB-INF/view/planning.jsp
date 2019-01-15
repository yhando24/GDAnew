<%@ include file="/Resources/inc/header.jsp"%>
<title>Planning</title>
</head>

<body>
	<%@ include file="/Resources/inc/navbar.jsp"%>
	<c:choose>
		<c:when test="${user.function.name == 'admin'}">
			<%@ include file="/Resources/inc/sidebar-admin.jsp"%>
		</c:when>
		<c:when test="${user.function.name == 'manager'}">
			<%@ include file="/Resources/inc/sidebar-manager.jsp"%>
		</c:when>
		<c:when test="${user.function.name == 'user'}">
			<%@ include file="/Resources/inc/sidebar-user.jsp"%>
		</c:when>
	</c:choose>

        <div class="container-fluid">
        
        <!-- Dï¿½but barre container-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="index.html">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Planning</li>
          </ol>
          <!-- Fin barre container-->

    <div class="container" >
            <div class="month text-center">
                  <ul>
                    <li class="prev">&#10094; </li>
                    <li class="next">&#10095; </li>
                    <li>
                        <h3>Janvier<br>2018</h3>
                    </li>
                  </ul>
            </div>     
<table class="table text-center">
              <thead>
                <tr>
                  <th >Lundi</th>
                  <th >Mardi</th>
                  <th >Mercredi</th>
                  <th >Jeudi</th>
                  <th >Vendredi</th>
                  <th >Samedi</th>
                  <th >Dimanche</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td class="passed-day">31</td>
                     <%@ page import = "java.io.*,java.util.*,java.lang.*, java.time.*" %>
                    <% String pattern = "yyyy-MM-dd";
         				String startDateStr = "";
         	  		  String endDateStr ="";

         				LocalDate startDate = LocalDate.of(2019, 1, 1);
         			%>
         	 	  <c:set var="indexDate" value="<%=startDate%>"/>
                	<c:forEach begin="1" end="31" varStatus="loop">
	   	
                	   <c:forEach items="${user.absences }" var="absence" >
                	   
                
                	    <c:choose>
                	    <c:when test="${indexDate >= absence.startDate && indexDate <= absence.endDate }">
                	   
                	   <c:if test="${absence.absenceType.id == '1'}">  <c:set var="type" value="couleur-conge-paye"/>
                	   </c:if>
              			   <c:if test="${absence.absenceType.id == '2'}"> <c:set var="type" value="couleur-rtt"/>
              			   </c:if>
              			   	  <c:if test="${absence.absenceType.id == '3'}"> <c:set var="type" value="couleur-conge-sans-solde"/>
              			   </c:if>
                	      <c:if test="${absence.absenceType.id == '5'}">  <c:set var="type" value="couleur-rtt-employeur"/>
                	      </c:if>
                	 
                	    </c:when>
                	    <c:otherwise>
                	   
                	      
                	  </c:otherwise>
                	    
                	    </c:choose>

                	 
                	   </c:forEach>
      					<td class="${type}">
                	   		${loop.index}
                	   </td>
                		<c:if test="${loop.index == '6'}">
                		 </tr><tr>
                		</c:if>
    
                			<c:if test="${loop.index  == '13'}">
                		 </tr><tr>
                		</c:if>
                			<c:if test="${loop.index  == '20'}">
                		 </tr><tr>
                		</c:if>
                			<c:if test="${loop.index  == '27'}">
                		 </tr><tr>
                		</c:if>
                	     	  <%  	
                	     	 startDate = startDate.plusDays(1);
                	  %>
                		  <c:set var="indexDate" value="<%=startDate%>"/>
                	</c:forEach>
                
               
                </tr>

              </tbody>
            </table>
<h3>L�gende :</h3>
            <div class="row text-center">


           <div class="couleur-conge-paye-legende col">Cong� pay�</div>
           <div class="couleur-rtt-legende col">RTT</div>
           <div class="couleur-conge-sans-solde-legende col">Cong� sans solde</div>
           <div class="couleur-jour-ferie-legende col">Jour f�ri�</div>
           <div class="couleur-rtt-employeur-legende col">RTT employeur</div>
           </div>

          </div> <!-- End Container -->
    </div>
    <%@ include file="/Resources/inc/footer.jsp"%>
