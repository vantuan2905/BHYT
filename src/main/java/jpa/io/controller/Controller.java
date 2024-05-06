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
        
       
        return ResponseEntity.ok(allUser);
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
    public ResponseEntity<User> check_log(@RequestBody LoginDTO login) {
    	List<User> allUser = userService.getListUser();
    	for(User i:allUser) {
    		System.out.println(i.getMabh()+"  "+i.getPassword()+"  "+login.getMabh()+ " "+login.getPassword());
    		if(i.getCccd().equals(login.getMabh())&&i.getPassword().equals(login.getPassword())) return ResponseEntity.ok(i);
    	}
    	return null;
    }
    //khai báo
    @PutMapping("/{userId}")
    public ResponseEntity<User> khai_bao(@RequestBody User user) {
    	 User user1 = userService.saveUser(user);
         return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    
    @GetMapping("/tinh/{userId}")
    public ResponseEntity<HoaDon> tinh(@PathVariable String username,@RequestParam int MaBaoHiem,@RequestParam String DoiTuong,@RequestParam String tinh,@RequestParam String huyen,@RequestParam String xa,@RequestParam int SoThang,@RequestParam String NoiKham,@RequestParam String LoaiBaoHiem){
    	CongTyBaoHiem cty=congTyBaoHiemService.getCongTyBaoHiem(username);
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
        
        int ck1=0;
        ArrayList<BaoHiem> ds1=(ArrayList<BaoHiem>) noiKCB.getDanhSachBaoHiem();
        for(int i=0;i<ds1.size();i++) {
        	if(ds1.get(i).getMaBaoHiem()==bh.getMaBaoHiem()) {
        		ds1.set(i, bh);ck1=1;
        	}
        }
        if(ck1==0) ds1.add(bh);
        
        int ck2=0;
        ArrayList<BaoHiem> ds2=(ArrayList<BaoHiem>) loaiBH.getDanhSachBaoHiem();
        for(int i=0;i<ds1.size();i++) {
        	if(ds2.get(i).getMaBaoHiem()==bh.getMaBaoHiem()) {
        		ds2.set(i, bh);ck1=1;
        	}
        }
        if(ck2==0) ds2.add(bh);
        
        fee=(long) (0.045*heso*MucThuNhap*HeSoLoaiBaoHiem*k);
        
        HoaDon hd=new HoaDon();
        hd.setNgayTao(start);
        hd.setTongTien((long) (0.045*MucThuNhap*HeSoLoaiBaoHiem*k));
        hd.setBaoHiem(bh);
        hd.setHoTro((long) ((1-heso)*0.045*heso*MucThuNhap*HeSoLoaiBaoHiem*k));
        hd.setTienNop(fee);
        ArrayList<HoaDon> ds=(ArrayList<HoaDon>)cty.getDanhSachHoaDon();
        ds.add(hd);
        cty.setDanhSachHoaDon(ds);
        return ResponseEntity.ok(hd);
    	
    }
}
