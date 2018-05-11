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

});