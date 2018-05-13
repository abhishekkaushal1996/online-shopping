$(function() {
	// for solving the active menu problem

	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'Home':
		$('#home').addClass('active');
		break;
	case 'All Products':
		$('#productList').addClass('active');
		break;
	default:
		$('#home').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}




//create data tables
// create dataset

var $table=$('#productListTable');


//execute when table will be present

if($table.length){
	//console.log('Inside the table!')
	
	var jsonURL='';
	if(window.categoryId==''){
		jsonURL= window.contextRoot+'/json/data/all/products';
	}else{
		jsonURL= window.contextRoot+'/json/data/category/'+window.categoryId+'/products';
	}
	$table.DataTable({
		lengthMenu: [[3,5,10,-1],['3 Records','5 records','10 Records','All Records']],
		pageLength: 5,
		ajax:{
			url: jsonURL,
			dataSrc:''  
		},
		columns:[
			{
				data:'code',
				mRender(data,type,row){
					return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
				}
			},
			{
				data:'name'
			},
			{
				data:'brand'
			},
			{
				data:'unitPrice',
				mRender:  function(data, type, row){
					return '&#8377; ' +data
				}
			},
			{
				data:'quantity',
				mRender: function(data, type,row){
					if(data<1){
						return '<span style="color:red">Out of Stock!!</span>';
					}
					return data;
				}
			}	,
			{
				data: 'id',
				bSortable:false,
				mRender: function(data, type,row){
					var str='';
					str+='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><i class="fas fa-eye"></i></a>&#160;';
					
					if(row.quantity<1){
						str+='<a href="javascriptt:void(0)" class="btn btn-success disabled"><i class="fas fa-cart-plus"></i></a>';
						
					}else{
						str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><i class="fas fa-cart-plus"></i></a>';
			
					}
					
					return str;
				}
			}
		]
	});
}


});