<%@page import="com.example.demo.model.User"%>
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

    <title>Update staff</title>

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

            <!-- Nav Item - Dashboard -->
            <li class="nav-item"><a class="nav-link" href="/showpackagelist">
                    <!-- <i class="fas fa-fw fa-tachometer-alt"></i> --> <i class="fas fa-tachometer-alt"></i>
                    <span>Manage package</span>
                </a></li>

            <!-- Divider -->
            <hr class="sidebar-divider my-0" />

            <!-- Heading -->
            <!-- <div class="sidebar-heading">
                Interface
            </div> -->

            <!-- Nav Item - Profile-->
            <li class="nav-item"><a class="nav-link" href="/showliability">
                    <!-- <i class="fas fa-fw fa-tachometer-alt"></i> --> <i class="far fa-user-circle fa-lg"></i>
                    <span>Manage Insurance Liability</span>
                </a></li>

            <!-- Divider -->

            <!-- Nav Item - History -->
            <li class="nav-item"><a class="nav-link" href="/showstafflist"> <i class="fas fa-file-contract fa-lg"></i>
                    <span>Manage staff</span></a></li>

            <!-- Divider -->

            <hr class="sidebar-divider" />
        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
            <!-- Main Content -->
            <div id="content">
                <!-- Topbar -->
                <nav class="
              navbar navbar-expand navbar-light
              bg-white
              topbar
              mb-4
              static-top
              shadow
            ">
                    <div class="container">
                        <!-- Page Heading -->
                        <h1 class="py-4 mb-4 text-center font-weight-bold text-primary">
                            Update staff </h1>
                    </div>
                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">
                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow"><a class="nav-link dropdown-toggle" href="#"
                                id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
                                aria-expanded="false"> <span
                                    class="mr-2 d-none d-lg-inline text-gray-600 small">
								<%
										User user = (User) request.getAttribute("user");
									%>
									${user.getUsername()}
								</span> <img
                                    class="img-profile rounded-circle" src="img/undraw_profile.svg" />
                            </a> <!-- Dropdown - User Information -->
                            <div class="
                    dropdown-menu dropdown-menu-right
                    shadow
                    animated--grow-in
                  " aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="/changepassword"> <i
                                        class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i> Change
                                    password
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/logout"> <i
                                        class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>
                    </ul>
                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <!--Contract-->
                <div class="row justify-content-center">
                    <div class="col-lg-6">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                              <h5 class="m-0 font-weight-bold text-primary">
                                Fill in staff information
                              </h5>
                            </div>
                            <div class="card-body">
                            <%ArrayList<User> list = (ArrayList<User>)request.getAttribute("staff");
    							User c = list.get(0);
    							%>                              
                              <form action="/updateStaff" method = 'POST'>                              
                                <div class="form-group">
                                    <label for="id" class="font-weight-bold">Id</label>
                                    <input type="text" class="form-control" id="areadamage" name="id" value="<%=c.getId()%>" readonly>                     
                                </div>
                                <div class="form-group">
                                  <label for="Name" class="font-weight-bold">Name</label>
                                  <input type="text" class="form-control" id="Name" name="name" value="<%=c.getName()%>">                     
                                </div>
            
                                <div class="form-group">
                                  <label for="ssn" class="font-weight-bold">Social security number</label>
                                  <input type="text" class="form-control" id="ssn" name="socialsercuritynumber" value="<%=c.getSocialsercuritynumber()%>">
                                </div>
            
                                <div class="form-group">
                                  <label for="Dob" class="font-weight-bold">Date of birth</label>
                                  <input type="text" class="form-control" id="Dob" name="dob" value="<%=c.getDob()%>">
                                </div>
            
                                <div class="form-group">
                                  <label for="Gender" class="font-weight-bold">Gender</label>
                                  <input type="radio" id="Gender" name="gender" value="true" <%=(c.isGender() == true?"checked":"")%>>Male
                                  <input type="radio" id="Gender" name="gender" value="false" <%=(c.isGender() == false?"checked":"")%>>Female
                                </div>

                                <div class="form-group">
                                    <label for="Address" class="font-weight-bold">Address</label>
                                    <input type="text" class="form-control" id="Address" name="address" value="<%=c.getAddress()%>">
                                </div>

                                <div class="form-group">
                                    <label for="Phone" class="font-weight-bold">Phone</label>
                                    <input type="text" class="form-control" id="Phone" name="phonenumber" value="<%=c.getPhonenumber()%>">
                                </div>

                                <div class="form-group">
                                    <label for="Email" class="font-weight-bold">Email</label>
                                    <input type="text" class="form-control" id="Email" name="email" value="<%=c.getEmail()%>">
                                </div>
                                <input type="hidden" name="username" value=<%=c.getUsername() %>>
                                <input type="hidden" name="password" value=<%=c.getPassword() %>>
                                
                                <div class="container text-center">
                                <button type="submit" class="btn btn-primary text-center">Update staff</button>
                                <a class="btn btn-primary" href="showstafflist" role="button">Back to staff list</a>
                                </div>
                            </form>
                            </div>
                          </div>
                    </div>
                </div>

                <!-- /.container-fluid -->
            </div>
            <!-- End of Main Content -->
        </div>
        <!-- Footer -->
        <footer class="sticky-footer bg-white">
        </footer>
        <!-- End of Footer -->

        <!-- End of Content Wrapper -->
    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top"> <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>
</body>

</html>