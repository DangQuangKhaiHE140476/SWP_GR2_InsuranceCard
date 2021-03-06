<!DOCTYPE html>
<%@page import="com.example.demo.model.User"%>
<%@page import="com.example.demo.model.InsuranceLiability"%>
<%@page import="com.example.demo.model.Contract"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Insurance card</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">
			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="/adminhome">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-motorcycle fa-sm"></i>
				</div>
				<div class="sidebar-brand-text mx-3">Insurance Card</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0" />

			<!-- Nav Item - Show customer list -->
			<li class="nav-item"><a class="nav-link" href="/customerlist">
					<!-- <i class="fas fa-fw fa-tachometer-alt"></i> --> <i
					class="fas fa-tachometer-alt"></i> <span>Show customer list</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider my-0" />

			<!-- Nav Item - View request list-->
			<li class="nav-item"><a class="nav-link" href="/requestmenu">
					<!-- <i class="fas fa-fw fa-tachometer-alt"></i> --> <i
					class="far fa-user-circle fa-lg"></i> <span>View request list</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider my-0" />

			<!-- Nav Item - Reported Accident list -->
			<li class="nav-item"><a class="nav-link"
				href="/reportedaccidentlist"> <i
					class="fas fa-file-contract fa-lg"></i> <span>Reported Accident list</span>
			</a></li>

			<!-- Divider -->

			<hr class="sidebar-divider" />

			<!-- Nav Item - Compensation list -->
			<li class="nav-item"><a class="nav-link"
				href="/compensationlist"> <i class="fas fa-file-contract fa-lg"></i>
					<span>Compensation list</span></a></li>

		</ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <div class="container">
						<!-- Page Heading -->
						<h1 class="py-4 text-center font-weight-bold text-primary">
							Contract detail</h1>
					</div>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">
                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow"><a class="nav-link dropdown-toggle" href="#"
                                id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
                                aria-expanded="false"> 
                                   <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                                  	<%
										User user = (User) request.getAttribute("user");
									%>
									${user.getUsername()}
                                   </span> 
                                   <img class="img-profile rounded-circle" src="img/undraw_profile.svg" />
                            </a> <!-- Dropdown - User Information -->
                            <div class="
                    dropdown-menu dropdown-menu-right
                    shadow
                    animated--grow-in
                  " aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="/viewprofile"> <i
                                        class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
                                </a> <a class="dropdown-item" href="/changepassword"> <i
                                        class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i> Change password
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/logout""> <i
                                        class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>
                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid row">

                    <!-- Page Heading -->
                    <div class="col-lg-8">
                        <div class="card shadow mb-4">
                            <div class="card-body">
                                <%Contract c = (Contract)request.getAttribute("contractdetail"); %>
                                <div>
                                    <h5>User information</h5>
                                    <div class="row py-3">
                                        <div class="col-lg-2">User name</div>
                                        <div>
                                            <%=c.getUser().getName() %>
                                        </div>
                                    </div>
                            
                                    <div class="row py-3">
                                        <div class="col-lg-2">Create date</div>
                                        <div>
                                            <%=c.getCreationdate() %>
                                        </div>
                                    </div>
                                </div>
    
                                <!-- Divider -->
                                <hr class="sidebar-divider" />
    
                                <div> 
                                    <h5>Vehicle information</h5>
                                    <div class="row py-3">
                                        <div class="col-lg-2">
                                            Owner's name
                                        </div>
                                        <div>
                                            <%=c.getVehicle().getOwnername() %>
                                        </div>
                                    </div>
                                    <div class="row py-3">
                                        <div class="col-lg-2">
                                            Type
                                        </div>
                                        <div>
                                            <%=c.getVehicle().getVehicleType().getVehicletype() %>
                                        </div>
                                    </div>
                                    <div class="row py-3">
                                        <div class="col-lg-2">
                                            Brand
                                        </div>
                                        <div>
                                            <%=c.getVehicle().getBrand() %>
                                        </div>
                                    </div>
                                    <div class="row py-3">
                                        <div class="col-lg-2">
                                            Model
                                        </div>
                                        <div>
                                            <%=c.getVehicle().getModel() %>
                                        </div>
                                    </div>
                                    <div class="row py-3">
                                        <div class="col-lg-2">
                                            Color
                                        </div>
                                        <div>
                                            <%=c.getVehicle().getColor() %>
                                        </div>
                                    </div>
                                    <div class="row py-3">
                                        <div class="col-lg-2">
                                            Register date
                                        </div>
                                        <div>
                                            <%=c.getVehicle().getRegistrationdate() %>
                                        </div>
                                    </div>
                                    <div class="row py-3">
                                        <div class="col-lg-2">
                                            Chassis number
                                        </div>
                                        <div>
                                            <%=c.getVehicle().getChassisnumber() %>
                                        </div>
                                    </div>
                                    <div class="row py-3">
                                        <div class="col-lg-2">
                                            Licience plate
                                        </div>
                                        <div>
                                            <%=c.getVehicle().getLicenseplates() %>
                                        </div>
                                    </div>
    
                                    <!-- Divider -->
                                    <hr class="sidebar-divider" />
                                    
                                    <div class="row py-3">
                                        <div class="col-lg-2">Liability</div>
                                        <div>
                                            <table class="table table-bordered" id="dataTable"
                                                width="100%" cellspacing="0">
                                                <thead>
                                                    <tr>
                                                        <th>ID</th>
                                                        <th>Level damage</th>
                                                        <th>Compensation amount</th>
                                                    </tr>
                                                </thead>
    
                                                <tbody>
                                                    <%for(InsuranceLiability il:c.getPackage_().getInsuranceLiabilities()){ %>
                                                    <tr>
                                                        <td><%=il.getId() %></td>
                                                        <td><%=il.getLevelDamage() %></td>
                                                        <td><%=il.getCompensationAmount() %></td>
                                                    </tr>
                                                    <%} %>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-lg-4">
                        <div class="col-lg-offset-2 py-2">
                            <a href="/contractpunishment?contractid=<%=c.getId()%>&userid=<%=request.getAttribute("customerid")%>"><button type="button" class="btn btn-primary btn-lg btn-block">Show punishment</button></a>
                        </div>
                        <div class="col-lg-offset-2 py-2">
                            <a href="/customercontractlist?userid=<%=request.getAttribute("customerid")%>&userid=<%=request.getAttribute("customerid")%>"><button type="button" class="btn btn-danger btn-lg btn-block">Back</button></a>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">??</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

</body>

</html>