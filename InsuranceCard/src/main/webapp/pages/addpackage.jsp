<!DOCTYPE html>
<%@page import="com.example.demo.model.InsuranceLiability"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.example.demo.model.InsuranceType"%>
<%@page import="com.example.demo.model.VehicleType"%>
<%@page import="java.util.List"%>
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

        <li class="nav-item"><a class="nav-link" href="/showpackagelist">
                <i class="fas fa-file-contract fa-lg"></i>
                <span>Manage package</span>
            </a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider my-0" />

        <li class="nav-item">
            <a class="nav-link" href="/showliability">
                <i class="fas fa-file-contract fa-lg"></i>
                <span>Manage Insurance liability</span>
            </a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider my-0" />

        <li class="nav-item"><a class="nav-link" href="/showstafflist"> 
                <i class="fas fa-file-contract fa-lg"></i>
                <span>Manage Staff</span>
            </a>
        </li>

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
							Add package</h1>
					</div>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>
                                <img class="img-profile rounded-circle"
                                    src="img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
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
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Enter package information</h6>
                            </div>
                            <div class="card-body">
                                <form class="form-horizontal" role="form" action="add">
                                    <div class="form-group row">
                                        <label for="Vehicletype" class="col-lg-2 control-label">Vehicle type</label>
                                        <div class="col-lg-8">
                                            <select class="form-control m-b-10" name="VehicleType">
                                                <%List<VehicleType> vehicleList = (List<VehicleType>) request.getAttribute("vehicleTypes");%>
                                                <%for(VehicleType vt:vehicleList){ %>
                                                <option value="<%=vt.getId()%>">
                                                    <%=vt.getVehicletype() %>
                                                </option>
                                                <%} %>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="Price" class="col-lg-2 control-label">Price</label>
                                        <div class="col-lg-8">
                                            <input type="text" class="form-control" name="Price">
                                        </div>
                                        <span class="align-text-bottom">VND</span>
                                    </div>
                                    <div class="form-group row">
                                        <label for="Duration" class="col-lg-2 control-label">Duration</label>
                                        <div class="col-lg-8">
                                            <input type="text" class="form-control" name="Duration">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="Insurancetype" class="col-lg-2 control-label">Insurance type</label>
                                        <div class="col-lg-8">
                                            <select class="form-control m-b-10" name="InsuranceType">
                                                <%List<InsuranceType> insuranceList = (List<InsuranceType>) request.getAttribute("insuraceTypes");%>
                                                <%for(InsuranceType it:insuranceList){ %>
                                                <option value="<%=it.getId()%>">
                                                    <%=it.getInsurancetype() %>
                                                </option>
                                                <%} %>
                                            </select>
                                        </div>
                                    </div>
									<div class="form-group row">
										<label for="Price" class="col-lg-2 control-label">Liability List</label>
										<div class="col-lg-8 row py-3">
											<table class="table table-bordered" id="dataTable"
												width="100%" cellspacing="0">
												<thead>
													<tr>
														<th>ID</th>
														<th>Level damage</th>
														<th>Compensation amount</th>
														<th>Select</th>
													</tr>
												</thead>

												<tbody>
													<%ArrayList<InsuranceLiability> ll = (ArrayList<InsuranceLiability>) request.getAttribute("insuranceLiabilities");%>
													<%
													for (InsuranceLiability il : ll) {
													%>
													<tr>
														<td><%=il.getId()%></td>
														<td><%=il.getLevelDamage()%></td>
														<td><%=il.getCompensationAmount()%></td>
														<td>
														    <input type="checkbox" name="liabilities" value="<%=il.getId()%>">
														</td>
													</tr>
													<%
													}
													%>
												</tbody>
											</table>
										</div>
									</div>
									<div class="form-group row">
                                        <div class="col-lg-offset-2 col-lg-6">
                                            <button type="submit" class="btn btn-primary btn-lg btn-block">Add package</button>
                                        </div>
                                        <div class="col-lg-offset-2 col-lg-6">
                                            <a href="showpackagelist"><button type="button" class="btn btn-danger btn-lg btn-block">Cancel</button></a>
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

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

</body>

</html>