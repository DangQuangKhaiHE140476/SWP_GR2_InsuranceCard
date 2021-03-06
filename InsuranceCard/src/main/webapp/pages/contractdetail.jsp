<%@page import="java.sql.Timestamp"%>
<%@page import="com.example.demo.common.DateUtils"%>
<%@page import="com.example.demo.model.User"%>
<%@page import="com.example.demo.model.Vehicle"%>
<%@page import="com.example.demo.model.InsuranceLiability"%>
<%@page import="java.util.List"%>
<%@page import="com.example.demo.model.Contract"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/adminhome">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-motorcycle fa-sm"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Insurance Card</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0" />

            <li class="nav-item"><a class="nav-link" href="/viewprofile">
                    <i class="fas fa-file-contract fa-lg"></i>
                    <span>View profile</span>
                </a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider my-0" />

            <li class="nav-item">
                <a class="nav-link" href="/historymenu">
                    <i class="fas fa-file-contract fa-lg"></i>
                    <span>History</span>
                </a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider my-0" />

            <li class="nav-item"><a class="nav-link" href="/contractpackagelist">
                    <i class="fas fa-file-contract fa-lg"></i>
                    <span>View contract package</span>
                </a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider" />
            
            <li class="nav-item"><a class="nav-link" href="/showcontractlist">
                    <i class="fas fa-file-contract fa-lg"></i>
                    <span>Your contract list</span>
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
                            Contract Detail</h1>
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

                    <div class="col-lg-8">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Contract information</h6>
                            </div>
                            <%DateUtils d = new DateUtils();%>
							<%ArrayList<Contract> list = (ArrayList<Contract>) request.getAttribute("contract"); %>
							<%Contract c = list.get(0); %>
                            <div class="card-body">
                                <div class="row py-3">
                                    <div class="col-lg-2">
                                        Created Date
                                    </div>
                                    <div>                                   
										<%=d.showDate(c.getCreationdate())%>
                                    </div>
                                </div>
                                <!-- Divider -->
                                <hr class="sidebar-divider my-0" />
                                <div class="row py-3">
                                    <div class="col-lg-2">
                                        Duration Date
                                    </div>
                                    <div>
										<%=c.getPackage_().getDuration()%>
                                    </div>
                                </div>
                                <!-- Divider -->
                                <hr class="sidebar-divider my-0" />
                                <div class="row py-3">
                                    <div class="col-lg-2">
                                        Status
                                    </div>
                                    <div>
										<%=c.getContractStatus().getStatus()%>
                                    </div>
                                </div>
                                <!-- Divider -->

                                <!-- Divider -->

                                <!-- Divider -->
                                <hr class="sidebar-divider my-0" />
                                <div class="row py-3">
                                    <div class="col-lg-2">
                                        Liability List
                                    </div>
                                    <div>
                                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                            <thead>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Level damage</th>
                                                    <th>Compensation amount</th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                        <%List<InsuranceLiability> ll = c.getPackage_().getInsuranceLiabilities();%>
                                        <%for(InsuranceLiability il:ll){ %>
                                        <tr>
                                            <td><%=il.getId() %></td>
                                            <td><%=il.getLevelDamage()%></td>
                                            <td><%=il.getCompensationAmount()%> VND</td>
                                        </tr>
                                        <%} %>
                                    </tbody>
                                        </table>
                                    </div>
                                </div>
                                <!-- Divider -->
                                <%Vehicle v = c.getVehicle();%>
                                <hr class="sidebar-divider my-0" />
                                <div class="row py-3">
                                    <div class="col-lg-2">
                                        Vehicle
                                    </div>
                                    <div class="card-body">
                                        <div class="row py-3">
                                            <div class="col-lg-3">
                                                Owner
                                            </div>
                                            <div>
												<%=v.getOwnername() %>
                                            </div>
                                        </div>
                                        <!-- Divider -->
                                        <hr class="sidebar-divider my-0" />
                                        <div class="row py-3">
                                            <div class="col-lg-3">
                                                Type Vehicle
                                            </div>
                                            <div>
												<%=v.getVehicleType().getVehicletype() %>
                                            </div>
                                        </div>
                                        <!-- Divider -->
                                        <hr class="sidebar-divider my-0" />
                                        <div class="row py-3">
                                            <div class="col-lg-3">
                                                Brand
                                            </div>
                                            <div>
												<%=v.getBrand() %>
                                            </div>
                                        </div>
                                        <!-- Divider -->
                                        <hr class="sidebar-divider my-0" />
                                        <div class="row py-3">
                                            <div class="col-lg-3">
                                                Model
                                            </div>
                                            <div>
												<%=v.getModel() %>
                                            </div>
                                        </div>
                                        <!-- Divider -->
                                        <hr class="sidebar-divider my-0" />
                                        <div class="row py-3">
                                            <div class="col-lg-3">
                                                Color
                                            </div>
                                            <div>
												<%=v.getColor() %>
                                            </div>
                                        </div>
                                        <!-- Divider -->
                                        <hr class="sidebar-divider my-0" />
                                        <div class="row py-3">
                                            <div class="col-lg-3">
                                                Registration date
                                            </div>
                                            <div>
												<%=d.showDate(new Timestamp(v.getRegistrationdate().getTime()))%>
                                            </div>
                                        </div>
                                        <!-- Divider -->
                                        <hr class="sidebar-divider my-0" />
                                        <div class="row py-3">
                                            <div class="col-lg-3">
                                                Chassisnumber
                                            </div>
                                            <div>
												<%=v.getChassisnumber() %>
                                            </div>
                                        </div>
                                        <!-- Divider -->
                                        <hr class="sidebar-divider my-0" />
                                        <div class="row py-3">
                                            <div class="col-lg-3">
                                                License plates
                                            </div>
                                            <div>
												<%=v.getLicenseplates() %>
                                            </div>
                                        </div>
                                        <!-- Divider -->
                                        <hr class="sidebar-divider my-0" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4">
                    <%if(!c.getContractStatus().getStatus().equals("TERMINATED")){ %>
                        <div class="col-lg-offset-2 py-2">
                            <a href="requestcontract?status=cancel&&id=<%=c.getId()%>"><button type="button"
                                    class="btn btn-primary btn-lg btn-block" onclick ="return confirm('Do you want to cancel this contract?')">Cancel Contract</button></a>
                        </div>

                        <div class="col-lg-offset-2 py-2">
                            <a href="requestcontract?status=renew&&id=<%=c.getId()%>"><button type="button"
                                    class="btn btn-primary btn-lg btn-block" onclick ="return confirm('Do you want to renew this contract?')">Renew Contract</button></a>
                        </div>

                        <div class="col-lg-offset-2 py-2">
                            <a href="/reportaccident"><button type="button"
                                    class="btn btn-primary btn-lg btn-block">Report Accident</button></a>
                        </div>
						<%} %>
                        <div class="col-lg-offset-2 py-2">
                            <a href="/showcontractlist"><button type="button"
                                    class="btn btn-primary btn-lg btn-block">Back to contract list</button></a>
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