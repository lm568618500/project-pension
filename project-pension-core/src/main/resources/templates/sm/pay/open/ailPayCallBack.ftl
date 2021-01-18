<html>
 <head></head>
 <body>
   payStatus ${payStatus} 
  <br /> callBackUrl ${callBackUrl} 
  <br /> param1 ${param1} 
  <br /> param2 ${param2} 
  <br /> randomKey ${randomKey} 
  <br /> timestamp ${timestamp} 
  <br /> sign ${sign} 
  <br /> 
  <form id="fm" method="POST" action="${callBackUrl}"> 
   <input type="hidden" name="payOrderId" value="${payOrderId}" /> 
   <input type="hidden" name="payOrderPrice" value="${payOrderPrice}" /> 
   <input type="hidden" name="mchOrderNo" value="${mchOrderNo}" /> 
   <input type="hidden" name="channelId" value="${channelId}" /> 
   <input type="hidden" name="channelItemsId" value="${channelItemsId}" /> 
   <input type="hidden" name="paySuccTime" value="${paySuccTime}" /> 
   <input type="hidden" name="payStatus" value="${payStatus}" /> 
   <input type="hidden" name="param1" value="${param1}" /> 
   <input type="hidden" name="param2" value="${param2}" /> 
   <input type="hidden" name="randomKey" value="${randomKey}" /> 
   <input type="hidden" name="timestamp" value="${timestamp}" /> 
   <input type="hidden" name="sign" value="${sign}" /> 
  </form> 
  <script>

window.onload= function(){
	document.getElementById('fm').submit();
}
</script>   
 </body>
</html>