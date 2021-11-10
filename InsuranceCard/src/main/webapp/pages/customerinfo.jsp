<!DOCTYPE html>
<%@page import="com.example.demo.model.User"%>
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
            <li class="nav-item"><a class="nav-link" href="#">
                    <!-- <i class="fas fa-fw fa-tachometer-alt"></i> --> <i class="fas fa-tachometer-alt"></i>
                    <span>Manage customer</span>
                </a></li>

            <!-- Divider -->
            <hr class="sidebar-divider my-0" />

            <!-- Nav Item - History-->
            <li class="nav-item"><a class="nav-link" href="#">
                    <!-- <i class="fas fa-fw fa-tachometer-alt"></i> --> <i class="far fa-user-circle fa-lg"></i>
                    <span>Manage contract</span>
                </a></li>

            <!-- Divider -->
            <hr class="sidebar-divider" />

            <!-- Nav Item - Contract Package List -->
            <li class="nav-item"><a class="nav-link" href="#"> <i class="fas fa-file-contract fa-lg"></i>
                    <span>View request list</span></a></li>

            <!-- Divider -->
            <hr class="sidebar-divider" />
            
            <!-- Nav Item - Contract List -->
            <li class="nav-item"><a class="nav-link" href="#"> <i class="fas fa-file-contract fa-lg"></i>
                    <span>Accident report</span></a></li>

            <!-- Divider -->
            <hr class="sidebar-divider" />

            <li class="nav-item"><a class="nav-link" href="#"> <i class="fas fa-file-contract fa-lg"></i>
                <span>Compensation list</span></a></li>

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
							Customer info</h1>
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
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Customer information</h6>
                            </div>
                            <div class="card-body">
                                <%User u = (User)request.getAttribute("customerinfo"); %>
                                <div class="row py-3">
                                    <div class="col-lg-2">
                                        User name
                                    </div>
                                    <div class="col-lg-4">
                                        <%=u.getUsername() %>
                                    </div>
                                    <div class="col-lg-2">
                                        ID
                                    </div>
                                    <div class="col-lg-4">
                                        <%=u.getId() %>
                                    </div>
                                </div>
                                <!-- Divider -->
                                <hr class="sidebar-divider my-0" />
                                <div class="row py-3">
                                    <div class="col-lg-2">
                                        Full name
                                    </div>
                                    <div>
                                        <%=u.getName() %>
                                    </div>
                                </div>
                                <!-- Divider -->
                                <hr class="sidebar-divider my-0" />
                                <div class="row py-3">
                                    <div class="col-lg-2">
                                        DOB
                                    </div>
                                    <div class="col-lg-4">
                                        <%=u.getDob() %>
                                    </div>
                                    <div class="col-lg-2">
                                        Gender
                                    </div>
                                    <div class="col-lg-4">
                                        <%if(u.isGender()){%>
                                            MALE
                                        <%} else{%>
                                            FEMALE
                                        <%} %>
                                    </div>
                                </div>
                                <!-- Divider -->
                                <hr class="sidebar-divider my-0" />
                                <div class="row py-3">
                                    <div class="col-lg-2">
                                        Social number
                                    </div>
                                    <div>
                                        <%=u.getSocialsercuritynumber() %>
                                    </div>
                                </div>
                                <!-- Divider -->
                                <hr class="sidebar-divider my-0" />
                                <div class="row py-3">
                                    <div class="col-lg-2">
                                        Address
                                    </div>
                                    <div>
                                        <%=u.getAddress() %>
                                    </div>
                                </div>
                                <!-- Divider -->
                                <hr class="sidebar-divider my-0" />
                                <div class="row py-3">
                                    <div class="col-lg-2">
                                        Phone number
                                    </div>
                                    <div>
                                        <%=u.getPhonenumber() %>
                                    </div>
                                </div>
                                <!-- Divider -->
                                <hr class="sidebar-divider my-0" />
                                <div class="row py-3">
                                    <div class="col-lg-2">
                                        Email
                                    </div>
                                    <div>
                                        <%=u.getEmail() %>
                                    </div>
                                </div>
                                <!-- Divider -->
                                <hr class="sidebar-divider my-0" />
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-lg-4">
                        <div class="col-lg-offset-2 py-2">
                            <a href="/customercontractlist?id=<%=u.getId()%>"><button type="button" class="btn btn-primary btn-lg btn-block">Customer contract</button></a>
                        </div>
                        <div class="col-lg-offset-2 py-2">
                            <a href="/customerlist"><button type="button" class="btn btn-danger btn-lg btn-block">Back</button></a>
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