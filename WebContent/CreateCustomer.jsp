
<!DOCTYPE html>
<html>
<head>
<script>


</script>


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Page title -->
    <title>CreateCustomerPage</title>

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <!--<link rel="shortcut icon" type="image/ico" href="favicon.ico" />-->

    <!-- Vendor styles -->
    <link rel="stylesheet" href="vendor/fontawesome/css/font-awesome.css" />
    <link rel="stylesheet" href="vendor/metisMenu/dist/metisMenu.css" />
    <link rel="stylesheet" href="vendor/animate.css/animate.css" />
    <link rel="stylesheet" href="vendor/bootstrap/dist/css/bootstrap.css" />

    <!-- App styles -->
    <link rel="stylesheet" href="fonts/pe-icon-7-stroke/css/pe-icon-7-stroke.css" />
   <link rel="stylesheet" href="fonts/pe-icon-7-stroke/css/helper.css" /> 
    <link rel="stylesheet" href="styles/style.css">
<style>
.button {
  border-radius: 4px;
  background-color: Green;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 20px;
  padding: 5px;
  width: 370px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
</style>
</head>
<body class="blank">
  <div><marquee><strong>Infinity DTH Services</strong></marquee></div>


<div class="color-line"></div>


<div class="login-container">
    <div class="row">
        <div class="col-md-12">
            <div class="text-center m-b-md">
                <h3>CREATE CUSTOMER</h3>
            </div>
            <div class="hpanel">
                <div class="panel-body">
                        <form action="Mainservlet?action=createcustomer" method="post">
                            
                            <div class="form-group">
                                <label class="control-label" for="firstname">Firstname</label>
                                <input type="text" title="Please enter your firstname" placeholder="enter your firstname" required="" value="" name="firstname" id="firstname" class="form-control">                         
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="lastname">Lastname</label>
                                <input type="text" title="Please enter your lastname" placeholder="enter your lastname" required="" value="" name="lastname" id="lastname" class="form-control">
                            </div>   
                            <div class="form-group">
                                <label class="control-label" for="emailid">Email Id</label>
                                <input type="text" placeholder="example@gmail.com" title="enter your email id" required="" value="" name="email" id="email" class="form-control">
                                
                            </div>   
                            <div class="form-group">
                                <label class="control-label" for="phoneno">Phone number</label>
                                <input type="text" placeholder="enter your phone no" title="Please enter your Phone no" required="" value="" name="phonenum" id="phonenum" class="form-control">
                            </div>  
                            <div class="form-group">
                                <label class="control-label" for="Address">Address</label>
                                <input type="text" placeholder="enter your address" title="Please enter your address" required="" value="" name="address" id="address" class="form-control">
                            </div> 
                            <div class="form-group">
                                <label class="control-label" for="Landmark">Landmark</label>
                                <input type="text" placeholder="enter your landmark" title="Please enter your landmark" required="" value="" name="landmark" id="landmark" class="form-control">
                            </div> 
                            <div class="form-group">
                                <label class="control-label" for="state">State</label>
                                <input type="text" placeholder="enter your state" title="Please enter your state" required="" value="" name="state" id="state" class="form-control">
                            </div> 
                            <div class="form-group">
                                <label class="control-label" for="city">City</label>
                                <input type="text" placeholder="enter your city" title="Please enter your city" required="" value="" name="city" id="city" class="form-control">
                            </div> 
                            <div class="form-group">
                                <label class="control-label" for="Zipcode">Zipcode</label>
                                <input type="text" placeholder="enter your zipcode" title="Please enter your zipcode" required="" value="" name="zipcode" id="zipcode" class="form-control">
                            </div> 
                            <div class="form-group">
                                <label class="control-label" for="creationdate">Creation date</label>
                                <input type="text" placeholder="enter your Creation date" title="Please enter your creation date" required="" value="" name="creationdate" id="creationdate" class="form-control">
                            </div>
                            
                            

<button class="button" onclick="myFunction()"><span>Create me!! </span></button>
                      
                        </form>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 text-center">
    </div>
</div>
</body>
</html>