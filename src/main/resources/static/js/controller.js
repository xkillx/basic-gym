app.controller('IndexController', ['$scope', function($scope) {
    
}]);

app.controller('KelasController', ['$scope', 'kelasService', function($scope, kelasService) {
    getListKelas();

    function getListKelas() {
        kelasService.getListKelas()
            .success(function (data) {
                $scope.kelas = data._embedded.kelas;
            })
            .error(function (error) {
                toastr.error(error.message, "Error!");
            });
    }

    $scope.editKelas = function(kelas) {
        $location.path('/kelas/edit/' + kelas.id);
    };
}]);

app.controller('KelasEditController', ['$scope', '$location', '$routeParams', 'kelasService', function($scope, $location, $routeParams, kelasService) {
    var id = $routeParams.id;

    getKelas(id);

    function getKelas(id) {
        kelasService.getKelas(id)
            .success(function(data) {
                $scope.kelas = data;
            })
            .error(function(error) {
                toastr.error(error.message, "Error!");
            });
    }

    $scope.updateKelas = function (kelas) {
        kelasService.updateKelas(kelas)
          .success(function () {
              $location.path('/kelas');
              toastr.success("Data berhasil diupdate", "SUCCESS");
          })
          .error(function (error) {
              toastr.error(error.message, "Error!");
          });
    };

    $scope.cancel = function() {
        $location.path('/kelas');
        toastr.info('Edit kelas dibatalkan.', "BATAL");
    };
}]);

app.controller('LoginController',
    ['$scope', '$rootScope', '$location', 'AuthenticationService',
    function ($scope, $rootScope, $location, AuthenticationService) {
        // reset login status
        AuthenticationService.ClearCredentials();
  
        $scope.login = function () {
            $scope.dataLoading = true;
            AuthenticationService.Login($scope.username, $scope.password, function(response) {
                if(response.success) {
                    AuthenticationService.SetCredentials($scope.username, $scope.password);
                    $location.path('/home');
                } else {
                    $scope.error = response.message;
                    $scope.dataLoading = false;
                }
            });
        };
    }]);

app.controller('MemberListController', ['$scope', '$location', 'memberService', function($scope, $location, memberService) {
    
    getListMember();

    function getListMember() {
        memberService.getListMember()
            .success(function (data) {
                $scope.member = data._embedded.member;
            })
            .error(function (error) {
                toastr.error(error.message, "Error!");
            });
    }

    $scope.deleteMember = function (id) {

        if (confirm("Yakin hapus data ini?")) {
            memberService.deleteMember(id)
                .success(function () {
                    toastr.success("Data berhasil dihapus", "SUCCESS");
                    getListMember();
                })
                .error(function (error) {
                    toastr.error(error.message, "Error!");
                });
        }
        else {
            toastr.info('Delete barang dibatalkan.', "BATAL");
        }
    };

    $scope.tambah = function() {
        $location.path('/member/tambah');
    };

    $scope.editMember = function(member) {
        $location.path('/member/edit/' + member.id);
    };
}]);

app.controller('MemberTambahController', ['$scope', '$location', 'memberService', 'kelasService', function($scope, $location, memberService, kelasService) {
    $scope.now = (new Date()).toString();
    
    kelasService.getListKelas()
        .success(function (data) {
            $scope.member.kelas = data._embedded.kelas[0].nama;
            $scope.member.biaya = data._embedded.kelas[0].biaya;
            $scope.member.biaya_daftar = data._embedded.kelas[0].biaya_daftar;
        })
        .error(function (error) {
            toastr.error(error.message, "Error!");
        });

    $scope.insertMember = function (member) {
        memberService.insertMember(member)
            .success(function () {
                toastr.success("Data berhasil disimpan", "SUCCESS");
                $location.path('/member');
            }).
            error(function(error) {
                toastr.error(error.message, "Error!");
            });
    };

    $scope.cancel = function() {
        $location.path('/member');
        toastr.info('Tambah member dibatalkan.', "BATAL");
    };
}]);

app.controller('MemberEditController', ['$scope', '$location', '$routeParams', 'memberService', function($scope, $location, $routeParams, memberService) {
    var id = $routeParams.id;

    getMember(id);

    function getMember(id) {
        memberService.getMember(id)
            .success(function(data) {
                $scope.member = data;
            })
            .error(function(error) {
                toastr.error(error.message, "Error!");
            });
    }

    $scope.updateMember = function (member) {
        memberService.updateMember(member)
          .success(function () {
              $location.path('/member');
              toastr.success("Data berhasil diupdate", "SUCCESS");
          })
          .error(function (error) {
              toastr.error(error.message, "Error!");
          });
    };

    $scope.cancel = function() {
        $location.path('/member');
        toastr.info('Edit member dibatalkan.', "BATAL");
    };
}]);

app.controller('PerpanjangController', ['$scope', '$location', '$routeParams', 'memberService', 'kelasService', 'perpanjangService', function($scope, $location, $routeParams, memberService, kelasService, perpanjangService) {
    var id = $routeParams.id;

    $scope.now = (new Date()).toString();

    kelasService.getKelas(1)
        .success(function (data) {
            $scope.perpanjang_member.biaya = data.biaya;
        })
        .error(function (error) {
            toastr.error(error.message, "Error!");
        });

    memberService.getMember(id)
        .success(function(data) {
            $scope.perpanjang_member.nama = data.nama;
        })
        .error(function(error) {
            toastr.error(error.message, "Error!");
        });

    $scope.insert = function(p) {
        perpanjangService.insert(p)
            .success(function () {
                $location.path('/member');
                toastr.success("Data berhasil disimpan", "SUCCESS");
            })
            .error(function (error) {
                toastr.error(error.message, "Error!");
            });
    }

    $scope.cancel = function() {
        $location.path('/member');
        toastr.info('Perpanjang member dibatalkan.', "BATAL");
    };
}]);

app.controller('PerpanjangListController', ['$scope', 'perpanjangService', function($scope, perpanjangService) {
    perpanjangService.gets()
        .success(function (data) {
            $scope.perpanjang_member = data._embedded.perpanjang_member;
        })
        .error(function (error) {
            toastr.error(error.message, "Error!");
        });
}]);

app.controller('BarangListController', ['$scope', '$location', 'barangService', function($scope, $location, barangService) {
    getListBarang();

    function getListBarang() {
        barangService.getListBarang()
            .success(function (data) {
                $scope.barang = data._embedded.barang;
            })
            .error(function (error) {
                toastr.error(error.message, "Error!");
            });
    }

    $scope.deleteBarang = function (id) {

        if (confirm("Yakin hapus data ini?")) {
            barangService.deleteBarang(id)
                .success(function () {
                    toastr.success("Data berhasil dihapus.", "SUCCESS");
                    getListBarang();
                })
                .error(function (error) {
                    toastr.error(error.message, "Error!");
                });
        }
        else {
            toastr.info('Delete barang dibatalkan.', "BATAL");
        }
    };

    $scope.tambahBarang = function() {
        $location.path('/barang/tambah');
    };

    $scope.editBarang = function(member) {
        $location.path('/barang/edit/' + member.id);
    };
}]);

app.controller('BarangTambahController', ['$scope', '$location', 'barangService', function($scope, $location, barangService) {
    $scope.insertBarang = function (barang) {
        barangService.insertBarang(barang)
            .success(function () {
                $location.path('/barang');
                toastr.success("Data berhasil disimpan.", "SUCCESS");
            })
            .error(function(error) {
                toastr.error(error.message, "Error!");
            });
    };

    $scope.cancel = function() {
        $location.path('/barang');
        toastr.info('Tambah barang dibatalkan.', "BATAL");
    };
}]);

app.controller('BarangEditController', ['$scope', '$location', '$routeParams', 'barangService', function($scope, $location, $routeParams, barangService) {
    var id = $routeParams.id;

    getBarang(id);

    function getBarang(id) {
        barangService.getBarang(id)
            .success(function(data) {
                $scope.barang = data;
            })
            .error(function(error) {
                toastr.error(error.message, "ERROR");
            });
    }

    $scope.updateBarang = function (barang) {
        barangService.updateBarang(barang)
          .success(function () {
              $location.path('/barang');
              toastr.success("Data berhasil diupdate", "SUCCESS");
          })
          .error(function (error) {
              toastr.error(error.message, "ERROR");
          });
    };

    $scope.cancel = function() {
        $location.path('/barang');
        toastr.info('Edit barang dibatalkan.', "BATAL");
    };
}]);

app.controller('NonMemberListController', ['$scope', '$location', 'nonMemberService', function($scope, $location, nonMemberService) {
    gets();

    function gets() {
        nonMemberService.gets()
            .success(function (data) {
                $scope.non_member = data._embedded.non_member;
            })
            .error(function (error) {
                toastr.error(error.message, "Error!");
            });
    }

    $scope.delete = function (id) {

        if (confirm("Yakin hapus data ini?")) {
            nonMemberService.delete(id)
                .success(function () {
                    toastr.success("Data berhasil dihapus", "SUCCESS");
                    gets();
                })
                .error(function (error) {
                    toastr.error(error.message, "Error!");
                });
        }
        else {
            toastr.info('Delete data Non Member dibatalkan.', "BATAL");
        }
    };

    $scope.tambah = function() {
        $location.path('/non-member/tambah');
    };

    $scope.edit = function(n) {
        $location.path('/non-member/edit/' + n.id);
    };
}]);

app.controller('NonMemberTambahController', ['$scope', '$location', 'nonMemberService', 'kelasService', function($scope, $location, nonMemberService, kelasService) {
    $scope.now = (new Date()).toString();

    kelasService.getListKelas()
        .success(function (data) {
            $scope.non_member.kelas = data._embedded.kelas[1].nama;
            $scope.non_member.biaya = data._embedded.kelas[1].biaya;
        })
        .error(function (error) {
            toastr.error(error.message, "Error!");
        });

    $scope.insert = function (n) {
        nonMemberService.insert(n)
            .success(function () {
                $location.path('/non-member');
                toastr.success("Data Non Member berhasil disimpan.", "SUCCESS");
            })
            .error(function(error) {
                toastr.error(error.message, "Error!");
            });
    };

    $scope.cancel = function() {
        $location.path('/non-member');
        toastr.info('Tambah data Non Member dibatalkan.', "BATAL");
    };
}]);

app.controller('NonMemberEditController', ['$scope', '$location', '$routeParams', 'nonMemberService', function($scope, $location, $routeParams, nonMemberService) {
    var id = $routeParams.id;

    get(id);

    function get(id) {
        nonMemberService.get(id)
            .success(function(data) {
                $scope.non_member = data;
            })
            .error(function(error) {
                toastr.error(error.message, "ERROR");
            });
    }

    $scope.update = function (n) {
        nonMemberService.update(n)
          .success(function () {
              $location.path('/non-member');
              toastr.success("Data Non Member berhasil diupdate", "SUCCESS");
          })
          .error(function (error) {
              toastr.error(error.message, "ERROR");
          });
    };

    $scope.cancel = function() {
        $location.path('/non-member');
        toastr.info('Edit data Non Member dibatalkan.', "BATAL");
    };
}]);

app.controller('PembelianListController', ['$scope', '$location', 'pembelianService', function($scope, $location, pembelianService) {
    gets();

    function gets() {
        pembelianService.gets()
            .success(function (data) {
                $scope.pembelian = data._embedded.pembelian;
            })
            .error(function (error) {
                toastr.error(error.message, "Error!");
            });
    }

    $scope.delete = function (id) {

        if (confirm("Yakin hapus data ini?")) {
            pembelianService.delete(id)
                .success(function () {
                    toastr.success("Transaksi pembelian berhasil dihapus", "SUCCESS");
                    gets();
                })
                .error(function (error) {
                    toastr.error(error.message, "Error!");
                });
        }
        else {
            toastr.info('Delete transaksi pembelian dibatalkan.', "BATAL");
        }
    };

    $scope.tambah = function() {
        $location.path('/pembelian/tambah');
    };
}]);

app.controller('PembelianTambahController', ['$scope', '$location', 'barangService', 'pembelianService', function($scope, $location, barangService, pembelianService) {
    $scope.now = (new Date()).toString();

    getListBarang();

    function getListBarang() {
        barangService.getListBarang()
            .success(function (data) {
                $scope.barang = data._embedded.barang;
            })
            .error(function (error) {
                toastr.error(error.message, "Error!");
            });
    }

    $scope.change = function() {
        $scope.pembelian.total = $scope.pembelian.harga_barang * $scope.pembelian.jumlah;
    }

    $scope.update = function() {
        $scope.pembelian.harga_barang = $scope.selectedItem.harga;
        $scope.pembelian.nama_barang = $scope.selectedItem.nama;
        $scope.pembelian.id_barang = $scope.selectedItem.id;
    }

    $scope.insert = function (n) {
        pembelianService.insert(n)
            .success(function () {
                $location.path('/pembelian');
                toastr.success("Transaksi pembelian berhasil disimpan.", "SUCCESS");
            })
            .error(function(error) {
                toastr.error(error.message, "Error!");
            });
    };

    $scope.cancel = function() {
        $location.path('/pembelian');
        toastr.info('Transaksi pembelian dibatalkan.', "BATAL");
    };
}]);

app.controller('PenjualanListController', ['$scope', '$location', 'penjualanService', function($scope, $location, penjualanService) {
    gets();

    function gets() {
        penjualanService.gets()
            .success(function (data) {
                $scope.penjualan = data._embedded.penjualan;
            })
            .error(function (error) {
                toastr.error(error.message, "Error!");
            });
    }

    $scope.delete = function (id) {

        if (confirm("Yakin hapus data ini?")) {
            penjualanService.delete(id)
                .success(function () {
                    toastr.success("Transaksi penjualan berhasil dihapus", "SUCCESS");
                    gets();
                })
                .error(function (error) {
                    toastr.error(error.message, "Error!");
                });
        }
        else {
            toastr.info('Delete transaksi penjualan dibatalkan.', "BATAL");
        }
    };

    $scope.tambah = function() {
        $location.path('/penjualan/tambah');
    };
}]);

app.controller('PenjualanTambahController', ['$scope', '$location', 'barangService', 'penjualanService', function($scope, $location, barangService, penjualanService) {
    $scope.now = (new Date()).toString();

    getListBarang();

    function getListBarang() {
        barangService.getListBarang()
            .success(function (data) {
                $scope.barang = data._embedded.barang;
            })
            .error(function (error) {
                toastr.error(error.message, "Error!");
            });
    }

    $scope.change = function() {
        $scope.penjualan.total = $scope.penjualan.harga_barang * $scope.penjualan.jumlah;
    }

    $scope.update = function() {
        $scope.penjualan.harga_barang = $scope.selectedItem.harga;
        $scope.penjualan.nama_barang = $scope.selectedItem.nama;
        $scope.penjualan.id_barang = $scope.selectedItem.id;
    }

    $scope.insert = function (n) {
        penjualanService.insert(n)
            .success(function () {
                $location.path('/penjualan');
                toastr.success("Transaksi penjualan berhasil disimpan.", "SUCCESS");
            })
            .error(function(error) {
                toastr.error(error.message, "Error!");
            });
    };

    $scope.cancel = function() {
        $location.path('/penjualan');
        toastr.info('Transaksi penjualan dibatalkan.', "BATAL");
    };
}]);

app.controller('RekapMemberController', ['$scope', function($scope) {
    $scope.judul = "Ini Halaman Rekap Member";
}]);

app.controller('RekapNonMemberController', ['$scope', function($scope) {
    $scope.judul = "Ini Halaman Rekap Non Member";
}]);

app.controller('RekapPenjualanController', ['$scope', function($scope) {
    $scope.judul = "Ini Halaman Rekap Penjulan";
}]);

app.controller('RekapPembelianController', ['$scope', function($scope) {
    $scope.judul = "Ini Halaman Rekap Pembelian";
}]);

app.controller('NavbarController', ['$scope', '$location', function($scope, $location) {
    $scope.$on('$routeChangesuccess', function(event, current) {
        $scope.path = $location.path();
    });
}]);