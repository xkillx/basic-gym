app.factory('memberService', ['$http', function($http) {

    var urlBase = '/api/member';
    var memberService = {};

    memberService.getListMember = function () {
        return $http.get(urlBase);
    };

    memberService.getMember = function (id) {
        return $http.get(urlBase + '/' + id);
    };

    memberService.insertMember = function (member) {
        return $http.post(urlBase, member);
    };

    memberService.updateMember = function (member) {
        return $http.put(urlBase + '/' + member.id_member, member)
    };

    memberService.deleteMember = function (id) {
        return $http.delete(urlBase + '/' + id);
    };

    return memberService;
}]);

app.factory('barangService', ['$http', function($http) {

    var urlBase = '/api/barang';
    var barangService = {};

    barangService.getListBarang = function () {
        return $http.get(urlBase);
    };

    barangService.getBarang = function (id) {
        return $http.get(urlBase + '/' + id);
    };

    barangService.insertBarang = function (barang) {
        return $http.post(urlBase, barang);
    };

    barangService.updateBarang = function (barang) {
        return $http.put(urlBase + '/' + barang.id_barang, barang)
    };

    barangService.deleteBarang = function (id) {
        return $http.delete(urlBase + '/' + id);
    };

    return barangService;
}]);

app.factory('nonMemberService', ['$http', function($http) {

    var urlBase = '/api/non_member';
    var nonMemberService = {};

    nonMemberService.gets = function () {
        return $http.get(urlBase);
    };

    nonMemberService.get = function (id) {
        return $http.get(urlBase + '/' + id);
    };

    nonMemberService.insert = function (nonMember) {
        return $http.post(urlBase, nonMember);
    };

    nonMemberService.update = function (nonMember) {
        return $http.put(urlBase + '/' + nonMember.id_nonmember, nonMember)
    };

    nonMemberService.delete = function (id) {
        return $http.delete(urlBase + '/' + id);
    };

    return nonMemberService;
}]);

app.factory('kelasService', ['$http', function($http) {

    var urlBase = '/api/kelas';
    var kelasService = {};

    kelasService.getListKelas = function () {
        return $http.get(urlBase);
    };

    kelasService.getKelas = function (id) {
        return $http.get(urlBase + '/' + id);
    };

    kelasService.insertKelas = function (kelas) {
        return $http.post(urlBase, kelas);
    };

    kelasService.updateKelas = function (kelas) {
        return $http.put(urlBase + '/' + kelas.id_kelas, kelas)
    };

    kelasService.deleteKelas = function (id) {
        return $http.delete(urlBase + '/' + id);
    };

    return kelasService;
}]);

app.factory('perpanjangService', ['$http', function($http) {

    var urlBase = '/api/perpanjang_member';
    var perpanjangService = {};

    perpanjangService.gets = function () {
        return $http.get(urlBase);
    };

    perpanjangService.get = function (id) {
        return $http.get(urlBase + '/' + id);
    };

    perpanjangService.insert = function (p) {
        return $http.post(urlBase, p);
    };

    perpanjangService.update = function (p) {
        return $http.put(urlBase + '/' + p.id_perpanjang, p)
    };

    perpanjangService.delete = function (id) {
        return $http.delete(urlBase + '/' + id);
    };

    return perpanjangService;
}]);

app.factory('penjualanService', ['$http', function($http) {

    var urlBase = '/api/penjualan';
    var penjualanService = {};

    penjualanService.gets = function () {
        return $http.get(urlBase);
    };

    penjualanService.get = function (id) {
        return $http.get(urlBase + '/' + id);
    };

    penjualanService.insert = function (p) {
        return $http.post(urlBase, p);
    };

    penjualanService.update = function (p) {
        return $http.put(urlBase + '/' + p.id_penjualan, p)
    };

    penjualanService.delete = function (id) {
        return $http.delete(urlBase + '/' + id);
    };

    return penjualanService;
}]);

