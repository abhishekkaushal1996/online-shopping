<div class="container">

	<div class="row">
		<div class="col-md-12">
		
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li>&#160;/&#160;</li>
				<li><a href="${contextRoot}/show/all/products">All Products</a></li>
				<li>&#160;/&#160; </li>
				<li class="active">${product.name}</li>
			</ol>
		
		
		</div>
	
	</div>
	
	
	<div class="row">
	
	<!-- To display images -->
		<div class="col-xs-12 col-md-4">
			<div class="thumbnail"><img src="${images}/${product.code}.jpg" class="img img-fluid"/></div>
		</div>
		
		<!-- Display product description -->
		
		<div class="col-xs-12 col-md-8" >
			<h3>${product.name}</h3>
			<hr/>
			
			<p>${product.description}</p>
			<hr/>
			
			<h4>Price: <strong> &#8377; ${product.unitPrice}</strong></h4>
			<hr/>
			
			
			<c:choose>
				<c:when test="${product.quantity < 1 }">
					<h6>Qty Available: <span style="color:red">Out of Stock!!</span></h6>
				
				</c:when>
				<c:otherwise>
					<h6>Qty Available: ${product.quantity}</h6>
				
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${product.quantity < 1 }">
					<a href="javascript:void(0)" class="btn btn-success disabled"><strike>Add To cart <i class="fas fa-cart-plus"></i></strike></a>
				
				</c:when>
				<c:otherwise>
					<a href="${contextRoot}/cart/add/${product.id}/products" class="btn btn-success">Add To cart <i class="fas fa-cart-plus"></i></a>
				
				</c:otherwise>
			</c:choose>
			
			
			
			<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
		</div>
	</div>


</div>