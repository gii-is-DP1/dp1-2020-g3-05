<%@ page contentType="text/html;charset=UTF-8" session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="trainingDetails">

    <h2>Información de entrenamiento</h2>


    <table class="table table-striped">
        <tr>
            <th>Nombre</th>
            <td><b><c:out value="${training.name}"/></b></td>
        </tr>
        <tr>
            <th>Descripción</th>
            <td><c:out value="${training.description}"/></td>
        </tr>
    </table>
    
    <c:if test="${not empty training.exercises}">
	    <h3>Ejercicios</h3>
	    <c:forEach var="exercise" items="${training.exercises}" varStatus="loop">
	    	<div class="row row-cols-1">
	  			<div class="col mb-4">
		          	<div class="card row no-gutters flex-row flex-nowrap justify-content-between">
					
					    <!--Card image -->
					    <c:if test="${not empty exercise.image}">
						    <div class="view overlay p-1">
						    	<img class="card-img-top" src="${exercise.image}"
						          alt="Card image cap">
						        <a href="#!">
						        	<div class="mask rgba-white-slight"></div>
						        </a>
							</div>
					    </c:if>
					
					      <!--Card content-->
					    <div class="card-body col pl-4">
					
							<!--Title-->
							<h4 class="card-title"><c:out value="${exercise.name}"/></h4>
							<!--Text-->
							<p class="card-text"><c:out value="${exercise.description}"/></p>
							<p class="card-text">
								<c:if test="${exercise.type.name == 'repetitive' and not empty exercise.numReps}">
									<strong class="mr-2">Num reps:</strong>
									<c:out value="${exercise.numReps}"/>
								</c:if>
								<c:if test="${exercise.type.name == 'temporary' and not empty exercise.time}">
									<strong class="mr-2">Time:</strong>
									<c:out value="${exercise.time}"/>
								</c:if>
							</p>
				   		</div>
		       		</div>
	       		</div>
	       	</div>
	    </c:forEach>
    </c:if>
    
    
    <div class="row no-gutters justify-content-between align-items-center mb-2">
		<h5 class="mt-4">Memorias del entrenamiento</h5>
		
	 	<spring:url value="{trainingId}/memories/new" var="addMemory">
	        <spring:param name="trainingId" value="${training.id}"/>
	    </spring:url>
	    <a href="${fn:escapeXml(addMemory)}" class="btn btn-blue btn-md right">Nueva</a>
    </div>
    
    <c:choose>
    	<c:when test="${empty training.memories}">
    		<div class="mb-4">No se ha incluido ninguna memoria</div>
    	</c:when>
    	<c:otherwise>
			<table class="table table-striped mb-4">
				<thead>
		        	<tr>
		            	<th>Fecha</th>
		            	<th>Texto</th>
		            	<th>Peso</th>
		            	<th></th>
		            	<th></th>
		        	</tr>
		       	</thead>
		       	<tbody>
		       		<c:forEach items="${training.memories}" var="memory">
		       			<tr>
		       				<td><c:out value="${memory.date}" /></td>
		       				<td><c:out value="${memory.text}" /></td>
		       				<td><c:out value="${memory.weight}" /></td>
		       				<td style="width: 40px;">							    
								<spring:url value="{trainingId}/memories/{memoryId}/delete" var="deleteMemory">
							        <spring:param name="trainingId" value="${training.id}"/>
							        <spring:param name="memoryId" value="${memory.id}"/>
							    </spring:url>
							    <a href="${fn:escapeXml(deleteMemory)}" class="btn btn-default">Borrar</a>
							</td>
		       				<td style="width: 40px;">			
								<spring:url value="{trainingId}/memories/{memoryId}/edit" var="editMemory">
							        <spring:param name="trainingId" value="${training.id}"/>
							        <spring:param name="memoryId" value="${memory.id}"/>
							    </spring:url>
							    <a href="${fn:escapeXml(editMemory)}" class="btn btn-default">Editar</a>
							</td>
		       			</tr>
		       		</c:forEach>
		       	</tbody>
		    </table>
	    </c:otherwise>
    </c:choose>
    
    
	<sec:authorize access="!hasAnyAuthority('admin', 'trainer')">
	    <a href="#" data-back-btn class="btn btn-default">Volver</a>
    </sec:authorize>
    
    <sec:authorize access="hasAnyAuthority('admin', 'trainer')">
	    <spring:url value="/trainings" var="backUrl">
	    </spring:url>
	    <a href="${fn:escapeXml(backUrl)}" class="btn btn-default">Volver</a>
    </sec:authorize>
	
	
	<sec:authorize access="hasAnyAuthority('admin', 'trainner')">
	
	    <spring:url value="{trainingId}/edit" var="editUrl">
	        <spring:param name="trainingId" value="${training.id}"/>
	    </spring:url>
	    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Editar</a>
	
	    <spring:url value="{trainingId}/delete" var="deleteUrl">
	        <spring:param name="trainingId" value="${training.id}"/>
	    </spring:url>
	    <a href="${fn:escapeXml(deleteUrl)}" class="btn btn-default">Borrar</a>
    
    </sec:authorize>

</petclinic:layout>
