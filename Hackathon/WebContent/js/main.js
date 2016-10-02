$(document).ready(function() {
    $("#submitButtonModal").click(function(){
       
        var uName= $("#userName").val();
        var passwd = $("#password").val();
            var dataToBeSent  = {
              uName : uName , //
              passwd: passwd
              }; // you can change parameter name
       
            $.ajax({
            	type : 'POST',  
            	url : 'ConnectFromUI', // Your Servlet mapping or JSP(not suggested)
                data :dataToBeSent, 

                  success : function(responseText) {
                	  $('#ajaxGetUserServletResponse').text(responseText); // create an empty div in your page with some id
                	  alert(responseText);
                  },
                  error: function(xhr, status, error) {
                	    alert(xhr.responseText);
                	 }
              });
        
    }); 
});