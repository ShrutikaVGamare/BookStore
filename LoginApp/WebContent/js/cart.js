// js file

$( document ).ready(function() {
    console.log( "ready!" );
    
    $("#addCartModalBtn").click(function()
    {
    	var shoppCart=new Object();
    	shoppCart.isbn=$("#modalISBN").val();
    	shoppCart.quantity=$("#modalCartSel").val();
    	shoppCart.title=$("#modalTitle").val();
    	shoppCart.price=$("#modalPrice").val();
    	shoppCart.description=$("#modalDescription").val();
    	shoppCart.category=$("#modalCategory").val();
    	shoppCart.price=$("#modalPrice").val();
    	shoppCart.cover=$("#modalCover").val();
    	var shoppingCart=JSON.stringify(shoppCart);
   	 $('#mycartModal').modal('hide');

    	$("#isbn").val($("#modalISBN").val());
    	$("#promocode").val($("#modalPromoCode").val());
    	$("#quantity").val($("#modalCartSel").val());
    	$("#price").val($("#modalPrice").val());
    	 $('#addtoCartHidden').submit();

    	
    }
    
    )
    $(".addtoCart").click(function(){
    	
    	var parent=$(this).parents('tr');
    	
    	 $(parent).each(function () {
    		 $('td', this).each(function () {
    		        var id = $(this).attr('abbr');
    		        var val=$(this).text();
    		        if(id=='modalCartSel')
    		        	{
    		        	console.log('Yes');
    		        	for(var i=1;i<=val;i++)
    		        		{
    		        		 $('#'+id).append($('<option>', { 
    		        		        value: i,
    		        		        text : i 
    		        		    }));
    		        		}
    		        	}else{
    		         $("#"+id).val(val);
    		        	}
    		     })
    	    });
    	 $('#mycartModal').modal('show');
    	
    }
    );

    $("#emptyCart").click(function() {
    	
    	$("#hiddenAction").val('emptyCart');
    	 $('#checkoutForm').submit();
	});
});