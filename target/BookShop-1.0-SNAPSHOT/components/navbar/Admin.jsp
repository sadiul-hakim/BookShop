<nav class="navbar navbar-expand-lg bg-primary navbar-dark navbar">
    <div class="container">
        <a class="navbar-brand" href="index.jspx"> <img src="img/icon/logo.png"
                                                       width="40" height="40" class="mr-2" /> <span style="font-size: 1.8rem;">E-Book</span>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown me-1">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="fa fa-user-circle me-1"></i> Admin
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="userProfile.jspx"><i class="fa fa-id-badge"></i> Profile</a></li>
                        <li><a class="dropdown-item" href=""><i class="fa fa-gear"></i> Change Password</a></li>
                    </ul>
                </li>
                <li class="nav-item"><a
                        class="nav-link active btn btn-light me-2 btn btn-light text-primary"
                        aria-current="page" href="LogoutServlet"><i
                            class="fa fa-sign-out"></i>
                        Logout
                    </a></li>
            </ul>
        </div>
    </div>
</nav>