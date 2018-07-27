<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page = "/main.jsp" />


<div class="container">
  <div class="container-fluid">   
	 
	<div id='calendar'></div> 
	
		<div id="eventContent" title="Event Details" style="display:none;">
		    Start: <span id="startTime"></span><br>
		    End: <span id="endTime"></span><br><br>
		    <p id="eventInfo"></p>
		    <p><strong><a id="eventLink" href="" target="_blank">Read More</a></strong></p>
		</div>	
     </div>  
    </div>
     		
<jsp:include page = "/javascript.inc.jsp" />
<script type="text/javascript" language="javascript" class="init">
	$(document).ready(function() {
	 
	    
	    $(function() { // document ready 
	    	
	        $('#calendar').fullCalendar({
	        	defaultView: 'agendaDay',
	            defaultDate: '2018-04-07',
	            editable: false,
	            selectable: false,
	            eventLimit: true, // allow "more" link when too many events
	            header: {
	              left: 'prev,next today',
	              center: 'title',
	              right: 'agendaDay,agendaTwoDay,agendaWeek,month'
	            },
	          defaultView: 'agendaDay',
	          views: { 
	            timelineThreeDays: {
	              type: 'timeline',
	              duration: { days: 1 }
	            }
	          },
	          resourceLabelText: 'Rooms',

	          resources: { // you can also specify a plain string like 'json/resources.json'
	            url: '../laboratorio/listarJson',	        
	            error: function() {
	              $('#script-warning').show();
	            }
	          },

	          events: { // you can also specify a plain string like 'json/events.json'
	            url: '../reserva/listarJson',
	            error: function() {
	              $('#script-warning').show();
	            }
	          }
	        });
	      
	      });
	});
</script>	


<jsp:include page = "/footer.jsp" />