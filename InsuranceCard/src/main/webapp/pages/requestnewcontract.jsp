<!DOCTYPE html>
<%@page import="com.example.demo.model.User"%>
<%@page import="com.example.demo.model.VehicleType"%>
<%@page import="com.example.demo.model.InsuranceLiability"%>
<%@page import="java.util.List"%>
<%@page import="com.example.demo.model.Package"%>
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
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/customermenu">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-motorcycle fa-sm"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Insurance Card</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0" />

            <!-- Nav Item - Profile -->
            <li class="nav-item"><a class="nav-link" href="/viewprofile">
                    <!-- <i class="fas fa-fw fa-tachometer-alt"></i> --> <i class="fas fa-tachometer-alt"></i>
                    <span>View Profile</span>
                </a></li>

            <!-- Divider -->
            <hr class="sidebar-divider my-0" />

            <!-- Nav Item - History-->
            <li class="nav-item"><a class="nav-link" href="/historymenu">
                    <!-- <i class="fas fa-fw fa-tachometer-alt"></i> --> <i class="far fa-user-circle fa-lg"></i>
                    <span>History</span>
                </a></li>

            <!-- Divider -->
            <hr class="sidebar-divider" />

            <!-- Nav Item - Contract Package List -->
            <li class="nav-item"><a class="nav-link" href="/contractpackagelist"> <i class="fas fa-file-contract fa-lg"></i>
                    <span>Contract Package List	</span></a></li>

            <!-- Divider -->
            <hr class="sidebar-divider" />
            
            <!-- Nav Item - Contract List -->
            <li class="nav-item"><a class="nav-link" href="/showcontractlist"> <i class="fas fa-file-contract fa-lg"></i>
                    <span>Your Contract List	</span></a></li>

            <!-- Divider -->

            <hr class="sidebar-divider" />
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
							Request New Contract</h1>
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
                <div class="container-fluid">

                    <div class="col-lg-8">
                        <div class="card shadow mb-4">
                            <div class="card-body">
                                <form class="form-horizontal" role="form" action="checkout">
                                    <div>
                                        <h5>User information</h5>
                                        <div class="row py-3">
                                            <div class="col-lg-2">User name</div>
                                            <div>
                                                <%=user.getName()%>
                                                <input type="hidden" class="form-control" name="userid" value="<%=user.getId()%>">
                                            </div>
                                        </div>
                                
                                        <div class="row py-3">
                                            <div class="col-lg-2">Create date</div>
                                            <div>
                                                <%=request.getAttribute("currentdate") %>
                                            </div>
                                        </div>
                                    </div>
                                
                                    <!-- Divider -->
                                    <hr class="sidebar-divider" />
                                
                                    <div>
                                
                                        <h5>Vehicle information</h5>
                                        <div class="form-group row pt-3">
                                            <label for="ownername" class="col-lg-2 col-sm-2 control-label text-right">Owner's name</label>
                                            <div class="col-lg-10">
                                                <input type="text" class="form-control" name="ownername">
                                            </div>
                                        </div>
                                        <div class="form-group row pt-3">
                                            <label for="vehicletype" class="col-lg-2 col-sm-2 control-label text-right">Vehicle type</label>
											<div class="col-lg-10">
												<%Package p = (Package) request.getAttribute("package");%>
												<input class="form-control" type="text" name="vehicletype" placeholder="<%=p.getVehicleType().getVehicletype()%>" disabled>
												<input class="form-control" type="hidden" name="vehicletype" value="<%=p.getVehicleType().getId()%>">
											</div>
										</div>
                                        <div class="form-group row pt-3">
                                            <label for="brand" class="col-lg-2 col-sm-2 control-label text-right">Brand</label>
                                            <div class="col-lg-10">
                                                <input type="text" class="form-control" name="brand">
                                            </div>
                                        </div>
                                        <div class="form-group row pt-3">
                                            <label for="model" class="col-lg-2 col-sm-2 control-label text-right">Model</label>
                                            <div class="col-lg-10">
                                                <input type="text" class="form-control" name="model">
                                            </div>
                                        </div>
                                        <div class="form-group row pt-3">
                                            <label for="color" class="col-lg-2 col-sm-2 control-label text-right">Color</label>
                                            <div class="col-lg-10">
                                                <input type="text" class="form-control" name="color">
                                            </div>
                                        </div>
                                        <div class="form-group row pt-3">
                                            <label for="registerdate" class="col-lg-2 col-sm-2 control-label text-right">Register date</label>
                                            <div class="col-lg-10">
                                                <input type="date" class="form-control" name="registerdate">
                                            </div>
                                        </div>
                                        <div class="form-group row pt-3">
                                            <label for="chassisnumber" class="col-lg-2 col-sm-2 control-label text-right">Chassis number</label>
                                            <div class="col-lg-10">
                                                <input type="text" class="form-control" name="chassisnumber">
                                            </div>
                                        </div>
                                        <div class="form-group row pt-3">
                                            <label for="licienseplate" class="col-lg-2 col-sm-2 control-label text-right">Liciense plate</label>
                                            <div class="col-lg-10">
                                                <input type="text" class="form-control" name="licienseplate">
                                            </div>
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
													<%
													List<InsuranceLiability> ll = p.getInsuranceLiabilities();
													for (InsuranceLiability il : ll) {
													%>
													<tr>
														<td><%=il.getId()%></td>
														<td><%=il.getLevelDamage()%></td>
														<td><%=il.getCompensationAmount()%></td>
													</tr>
													<%}%>
												</tbody>
											</table>
											<input type="hidden" class="form-control" name="packageid" value="<%=p.getId()%>">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-lg-offset-2 col-lg-6">
                                            <button type="submit" class="btn btn-primary btn-lg btn-block">Request new package</button>
                                        </div>
                                        <div class="col-lg-offset-2 col-lg-6">
                                            <a href="contractpackagelist"><button type="button" class="btn btn-danger btn-lg btn-block">Cancel</button></a>
                                        </div>
                                    </div>
                                </form>
                            </div>
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
                        <span aria-hidden="true">×</span>
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