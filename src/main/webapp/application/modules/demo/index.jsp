<%@ include file="../common/init.jsp"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<html>
  <head>
  	<s:url id="contextPath" value="/" />
    <sj:head jqueryui="true" jquerytheme="base" customBasepath="%{contextPath}application/template/themes" />
    <script type="text/javascript">
	    $.subscribe('rowselect', function(event,data) {
	        $("#gridinfo").html('<p>Edit Mode for Row : '+event.originalEvent.id+'</p>');
	    });
    	$.subscribe('oneditsuccess', function(event, data){
			var message = event.originalEvent.response.statusText;
			$("#gridinfo").html('<p>Status: ' + message + '</p>');
		});
        $.subscribe('rowadd', function(event,data) {
            $("#gridtable").jqGrid('editGridRow',"new",{height:280,reloadAfterSubmit:false});
      	});
        $.subscribe('searchgrid', function(event,data) {
            $("#gridtable").jqGrid('searchGrid', {sopt:['cn','bw','eq','ne','lt','gt','ew']} );
      	});
	</script>  
  </head>
  <body>
    <s:url id="remoteurl" action="demoAction"/>
    <s:url id="editurl" action="../../../demo/demoEditAction"/>
    <sjg:grid
        id="gridtable"
        dataType="json"
        href="%{remoteurl}"
        pager="true"
        autowidth="true"
        navigator="true"
        navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
        navigatorAddOptions="{height:280,reloadAfterSubmit:true}"
        navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
        navigatorView="true"
        navigatorDelete="true"
        navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}"
        gridModel="gridModel"
        rowList="10,15,20"
        rowNum="15"
		editurl="%{editurl}"
    	onSelectRowTopics="rowselect"
    	onEditInlineSuccessTopics="oneditsuccess"
    	multiselect="true"
    >
        <sjg:gridColumn name="id" index="id" title="Id" formatter="integer" sortable="true" />
        <sjg:gridColumn name="title" index="title" title="Title" editable="true" edittype="text"/>
        <sjg:gridColumn name="content" index="content" title="Content" editable="true" edittype="textarea" sortable="false" search="false" />
        <sjg:gridColumn name="publishdate" index="publishdate" title="Publishdate" sortable="false" />
    </sjg:grid>
    
   	<div id="gridinfo" class="ui-widget-content ui-corner-all"><p>Edit Mode for Row :</p></div>
  </body>
</html>