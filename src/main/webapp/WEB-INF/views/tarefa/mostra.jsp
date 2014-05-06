<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="resources/css/jquery-ui-1.10.3.custom.css" rel="stylesheet">
<script src="resources/js/jquery-1.9.1.js"></script>
<script src="resources/js/jquery-ui-1.10.3.custom.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Tarefa</title>
</head>
<body>

<h3>Alterar tarefa - ${tarefa.id}</h3>

  <form action="alteraTarefa" method="post">

    <input type="hidden" name="id" value="${tarefa.id}" />
  
    Descrição:<br />
    <textarea name="descricao" cols="100" rows="5">
      ${tarefa.descricao}
    </textarea>
    <br />      

    Finalizado? <input type="checkbox" name="finalizado" value="true" ${tarefa.finalizado? 'checked' : '' }/> <br />      

    Data de finalização: <br />
    <input id="dataFinalizacao" type="text" name="dataFinalizacao" value="<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" /> "/>
    <br />
  
    <input type="submit" value="Alterar"/>
  </form>

<script>
  $(function() {
	    $("#dataFinalizacao").datepicker({
		    dateFormat: 'dd/mm/yy',
		    dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
		    dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
		    dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
		    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
		    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
		    nextText: 'Próximo',
		    prevText: 'Anterior'
		});    
  });
</script>

</body>
</html>