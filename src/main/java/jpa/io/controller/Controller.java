package jpa.io.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jpa.io.entities.BaoHiem;
import jpa.io.entities.CongTyBaoHiem;
import jpa.io.entities.HoaDon;
import jpa.io.entities.LoaiHinhBaoHiem;
import jpa.io.entities.LoginDTO;
import jpa.io.entities.NoiDangKy;
import jpa.io.entities.User;
import jpa.io.services.BaoHiemService;
import jpa.io.services.CongTyBaoHiemService;
import jpa.io.services.LoaiHinhBaoHiemService;
import jpa.io.services.NoiDangKiService;
import jpa.io.services.UserService;

@RestController
@RequestMapping("/users")
public class Controller {
	@Autowired
	UserService userService;
	
	@Autowired
	BaoHiemService baoHiemService;
	
	@Autowired
	NoiDangKiService noiDangKiService;
	
	@Autowired
	LoaiHinhBaoHiemService loaiHinhBaoHiemService;
	
	@Autowired
	CongTyBaoHiemService congTyBaoHiemService;
	@GetMapping("/test")
    public ResponseEntity<List<User>> getAllUser2() {
    	User u=new User();
    	u.setUserId(0);
    	BaoHiem bh=new BaoHiem();
    	bh.setMaBaoHiem(0);
    	bh.setUser(u);
    	baoHiemService.save(bh);
        List<User> allUser = userService.getListUser();
        
        //
        BaoHiem b1=new BaoHiem();
        b1.setMaBaoHiem(1);
        BaoHiem b2=new BaoHiem();
        b2.setMaBaoHiem(2);
        
        LoaiHinhBaoHiem lh=new LoaiHinhBaoHiem();
        lh.setMaLoai("abc");
        ArrayList<BaoHiem> ds=new ArrayList<>();
        ds.add(b1);ds.add(b2);
        lh.setDanhSachBaoHiem(ds);
        loaiHinhBaoHiemService.save(lh);
        
        
        NoiDangKy nk=new NoiDangKy();
        nk.setMaSoNoiDangKi("xyz");
        ArrayList<BaoHiem> ds2=new ArrayList<>();
        ds2.add(b1);ds2.add(b2);
        nk.setDanhSachBaoHiem(ds2);
        noiDangKiService.save(nk);
        
        //
        HoaDon h1=new HoaDon();
       // h1.setMaHoaDon(0);
        h1.setBaoHiem(b1);
        HoaDon h2=new HoaDon();
       // h2.setMaHoaDon(0);
        h2.setBaoHiem(b2);
        ArrayList<HoaDon> ds3=new ArrayList<>();
        ds3.add(h1);ds3.add(h2);
        
        CongTyBaoHiem c1=new CongTyBaoHiem();
        c1.setCongTyBaoHiemId("may");
        c1.setDanhSachHoaDon(ds3);
        congTyBaoHiemService.save(c1);
        NoiDangKy noiKCB=noiDangKiService.findBenhVien("Gia Loc");
        ArrayList<BaoHiem> ds1=(ArrayList<BaoHiem>) noiKCB.getDanhSachBaoHiem();
        System.out.println(ds1.size());
        return ResponseEntity.ok(allUser);
    }
	@GetMapping("/insertdb")
    public int insertdata() {
		User u1=new User();
		u1.setTen("Thanh");
		u1.setCccd("020014238654");
		u1.setEmail("hoangthanh@gmail.com");
		u1.setSdt("0563049675");
		u1.setDiaChi("Phuong Hung - Gia Loc - Hai Duong");
		
		User u2=new User();
		u2.setTen("Lien");
		u2.setCccd("030202111222");
		u2.setEmail("lienvu@gmail.com");
		u2.setSdt("0563049675");
		u2.setDiaChi("Khuong Thuong - Dong Da - Ha Noi");
		
		BaoHiem b1=new BaoHiem();
		u1.setMabh(1);
		b1.setUser(u1);
		baoHiemService.save(b1);
		
		BaoHiem b2=new BaoHiem();
		u2.setMabh(2);
		b2.setUser(u2);
		baoHiemService.save(b2);
		
		LoaiHinhBaoHiem l1=new LoaiHinhBaoHiem();
		l1.setMaLoai("CB");
		l1.setBoiThuong(0);
		l1.setMoTa("");
		l1.setPhanTramPhi(30);
		l1.setTenLoai("Co Ban");
		ArrayList<BaoHiem> ds1=new ArrayList<>();
        ds1.add(b1);
        l1.setDanhSachBaoHiem(ds1);
        loaiHinhBaoHiemService.save(l1);
        
		LoaiHinhBaoHiem l2=new LoaiHinhBaoHiem();
		l2.setMaLoai("PM");
		l2.setBoiThuong(0);
		l2.setMoTa("");
		l2.setPhanTramPhi(30);
		l2.setTenLoai("Phong Mach");
		
		ArrayList<BaoHiem> ds2=new ArrayList<>();
        ds2.add(b2);
        l2.setDanhSachBaoHiem(ds2);
        loaiHinhBaoHiemService.save(l2);
        
        NoiDangKy n1=new NoiDangKy();
        n1.setMaSoNoiDangKi("BV001");
        n1.setTen("Benh vien huyen Gia Loc");
        n1.setTinh("Hai Duong");
        n1.setHuyen("Gia Loc");
        n1.setXa("Thi tran Gia Loc");
        ArrayList<BaoHiem> ds3=new ArrayList<>();
        ds3.add(b1);
        n1.setDanhSachBaoHiem(ds3);
        noiDangKiService.save(n1);
        
        NoiDangKy n3=new NoiDangKy();
        n3.setMaSoNoiDangKi("TYT001");
        n3.setTen("Tram y te xa Le Loi");
        n3.setTinh("Hai Duong");
        n3.setHuyen("Gia Loc");
        n3.setXa("Le Loi");
        noiDangKiService.save(n3);
        
        NoiDangKy n2=new NoiDangKy();
        n2.setMaSoNoiDangKi("BV002");
        n2.setTen("Benh vien quan Dong Da");
        n2.setTinh("Ha Noi");
        n2.setHuyen("Dong Da");
        n2.setXa("Tay Son");
        noiDangKiService.save(n2);
        NoiDangKy n4=new NoiDangKy();
        n4.setMaSoNoiDangKi("TYT002");
        n4.setTen("Tram y te phuong Khuong Thuong");
        n4.setTinh("Ha Noi");
        n4.setHuyen("Dong Da");
        n4.setXa("Khuong Thuong");
        ArrayList<BaoHiem> ds4=new ArrayList<>();
        ds4.add(b2);
        n4.setDanhSachBaoHiem(ds4);
        noiDangKiService.save(n4);
        
        CongTyBaoHiem cty1=new CongTyBaoHiem();
        cty1.setCongTyBaoHiemId("BH0");
        cty1.setTenCongTy("Bao Hiem Gia Loc");
        cty1.setSdt("0974200530");
        cty1.setTinh("Hai Duong");
        cty1.setHuyen("Gia Loc");
        cty1.setXa("Le Loi");
        congTyBaoHiemService.save(cty1);
        CongTyBaoHiem cty2=new CongTyBaoHiem();
        cty2.setCongTyBaoHiemId("BH1");
        cty2.setTenCongTy("Bao Hiem Dong Da");
        cty2.setSdt("0974200530");
        cty2.setTinh("Ha Noi");
        cty2.setHuyen("Dong Da");
        cty2.setXa("Khuong Thuong");
        congTyBaoHiemService.save(cty2);
    	return 1;
    }
	 //all user get
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
    	System.out.println("okk");
        List<User> allUser = userService.getListUser();
        return ResponseEntity.ok(allUser);
    }
    @GetMapping("/{mabh}")
    public ResponseEntity<User> getUserViaMabh(@PathVariable int mabh) {
    	
        return ResponseEntity.ok(userService.getUserByMaBaoHiem(mabh));
    }
    //create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    //check login
    @GetMapping("/check_log")
    public int check_log(@RequestBody LoginDTO login) {
    	List<User> allUser = userService.getListUser();
    	for(User i:allUser) {
    		System.out.println(i.getCccd()+"  "+i.getPassword()+"  "+login.getUsername()+ " "+login.getPassword());
    		if(i.getCccd().equals(login.getUsername())&&i.getPassword().equals(login.getPassword())) return i.getUserId();
    	}
    	return 0;
    }
    //khai báo
    @PutMapping("/{userId}")
    public ResponseEntity<User> khai_bao(@RequestBody User user) {
    	 User user1 = userService.saveUser(user);
         return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    
    @GetMapping("/tinh")
    public ResponseEntity<HoaDon> tinh(@RequestParam int MaBaoHiem,@RequestParam String DoiTuong,@RequestParam String tinh,@RequestParam String huyen,@RequestParam String xa,@RequestParam int SoThang,@RequestParam String NoiKham,@RequestParam String LoaiBaoHiem){
    	CongTyBaoHiem cty=congTyBaoHiemService.getCongTyBaoHiemByDiaChi(tinh, huyen, xa);
    	long fee=0,MucThuNhap=4500000;float heso=1;
    	User user=userService.getUserByMaBaoHiem(MaBaoHiem);
    	if(DoiTuong.equals("Sinh Vien")) { heso=0.7f;MucThuNhap=1500000;}
    	if(DoiTuong.equals("Ho Can Ngheo")) { heso=0.3f;MucThuNhap=1500000;}
    	if(DoiTuong.equals("Ho Ngheo")) heso=0;
    	double k=1;
    	LoaiHinhBaoHiem loaiBH=loaiHinhBaoHiemService.findByTenLoai(LoaiBaoHiem);
    	
    	float HeSoLoaiBaoHiem=1;
    	if(loaiBH.equals("Bao Hiem Phong Mach")) HeSoLoaiBaoHiem=1.5f;
    	if(loaiBH.equals("Bao Hiem Hiem Ngheo")) HeSoLoaiBaoHiem=1.8f;
    	
    	NoiDangKy noiKCB;
    	if(NoiKham.equals("Tram y te")) noiKCB=noiDangKiService.findTYT(tinh, huyen, xa);
    	else { noiKCB=noiDangKiService.findBenhVien(huyen);k=1.15;}
    	
    	BaoHiem bh=baoHiemService.findBaoHiem(MaBaoHiem);
    	 // Lấy thời gian hiện tại
        LocalDateTime now = LocalDateTime.now();
        
        // Định dạng ngày tháng
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        // Chuyển đổi thành chuỗi
        String start = now.format(formatter);
        
        // Cộng thêm 1 năm
        LocalDateTime nextYear = now.plusYears(1);
        
        // Định dạng ngày tháng
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        // Chuyển đổi thành chuỗi
        String end = nextYear.format(formatter);
        bh.setBatDau(start);bh.setKetThuc(end);
        bh.setUser(user);
        System.out.println(noiKCB.getHuyen()+" "+noiKCB.getMaSoNoiDangKi() );
        int ck1=0;
        List<BaoHiem> ds1= noiKCB.getDanhSachBaoHiem();
        System.out.println(ds1.size());
        for(int i=0;i<ds1.size();i++) {
        	if(ds1.get(i).getMaBaoHiem()==bh.getMaBaoHiem()) {
        		ds1.set(i, bh);ck1=1;
        	}
        }
        if(ck1==0) ds1.add(bh);
        
        int ck2=0;
        List<BaoHiem> ds2=loaiBH.getDanhSachBaoHiem();
        for(int i=0;i<ds2.size();i++) {
        	if(ds2.get(i).getMaBaoHiem()==bh.getMaBaoHiem()) {
        		ds2.set(i, bh);ck1=1;
        	}
        }
        if(ck2==0) ds2.add(bh);
        
        fee=(long) (0.045*heso*MucThuNhap*HeSoLoaiBaoHiem*k*SoThang);
        
        HoaDon hd=new HoaDon();hd.setMaHoaDon(20);
        hd.setNgayTao(start);
        hd.setTongTien((long) (0.045*MucThuNhap*HeSoLoaiBaoHiem*k*SoThang));
        hd.setBaoHiem(bh);
        hd.setHoTro((long) ((1-heso)*0.045*heso*MucThuNhap*HeSoLoaiBaoHiem*k*SoThang));
        hd.setTienNop(fee);
        List<HoaDon> ds=cty.getDanhSachHoaDon();
        ds.add(hd);
        hd.setMaHoaDon(ds.size()+1);
        cty.setDanhSachHoaDon(new ArrayList<>());
        cty.setDanhSachHoaDon(ds);
        
        congTyBaoHiemService.save(cty);
    	System.out.println("ok"+" "  +hd.getTienNop()+" "+hd.getMaHoaDon()  );
        return ResponseEntity.ok(hd);
    	
    }
}
