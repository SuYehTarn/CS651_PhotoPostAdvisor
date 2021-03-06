<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Photo Advisor</title>

<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>


<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-QHGTX21K6N"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'G-QHGTX21K6N');
  gtag('send', 'front_page_view', location.pathname);
</script>
</head>
<body class="bg-dark">


<script>
	function statusChangeCallback(response) {
		if (response.status === 'connected') {
			console.log(response);
			let token = FB.getAuthResponse()['accessToken'];
			console.log("token: " + token);
			window.location.href = '/GetPageId?access_token=' + token;
  		} else {
			console.log(response);
  			console.log('Please log into this webpage.');
		}
	}
	
	function FBLogin() {
		console.log('Try to login FB');
		FB.login(function(response){ // step 1
			console.log('Getting FB login status')
			console.log(response)
			FB.getLoginStatus(function(response) {
				statusChangeCallback(response);
			});
		}, {scope: 'public_profile, email, pages_manage_posts, pages_read_engagement, pages_read_user_content'}); // step 2
		
	}
	
	window.fbAsyncInit = function() {
		FB.init({
			appId            : '3487271691379308',			
			autoLogAppEvents : true,
			xfbml            : true,
			version          : 'v10.0'
		});
		
		FB.getLoginStatus(function(response) {
			statusChangeCallback(response);
		});
	};
	
</script>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js"></script>

<div class="m-4 align-middle text-center bg-light p-4 rounded-3">
   <h1>Photo Advisor</h1>
   <p class="lead">Analysis your FB page photo posts.</p>
   <button class="btn btn-lg btn-primary" onclick="FBLogin()">Go Analysis</button>
</div>

</body>
</html>