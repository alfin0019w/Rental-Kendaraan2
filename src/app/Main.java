package app;

// import model.Kendaraan;
import controller.RentarController;
import model.Mobil;
import model.Motor;
import model.PenyewaanRepository;
import model.PenyewaanRepositoryArrayList;
import view.RentalView;
import view.RentalViewCli;
import view.StrukView;
import view.StrukViewCli;
import model.Kendaraan;
import model.KendaraanFactory;
import model.KendaraanFactoryDefault;
import model.KendaraanRepository;
import model.KendaraanRepositoryArrayList;
//import model.Kendaraan;
import model.Minibus;
import model.MobilPremium;

//[DPI] main adalah composition root satu satunya tempat yang mengenal kelas konkret 
//      disinilah semua object dirakit lalu disuntiknan/deoendencies ke controller
//      
public class Main {
    public static void main(String[] args) {

        KendaraanRepository kendaraanRepository = new KendaraanRepositoryArrayList();
        PenyewaanRepository penyewaanRepository = new PenyewaanRepositoryArrayList();
        KendaraanFactory kendaraanFactory = new KendaraanFactoryDefault();
        RentalView view = new RentalViewCli();
        StrukView strukView = new StrukViewCli();

        RentarController controller = new RentarController(
                kendaraanRepository,
                penyewaanRepository,
                view,
                strukView,
                kendaraanFactory
        );

        // tambah data awall// data dummy
        controller.tambahDataAwal(new Mobil(
                "B 1234 ABC",
                "Toyota Avanza",
                300000));

        controller.tambahDataAwal(new Motor(
                "B 5678 DEF",
                "Honda Vario",
                100000));

        controller.tambahDataAwal(new Mobil(
                "B 9012 GHI",
                "Suzuki Swift",
                250000));

        controller.tambahDataAwal(new Minibus(
                "L 7777 GH",
                "Toyota Hiace",
                900000));

        controller.tambahDataAwal(new MobilPremium(
                "L 9999 VIP",
                "Toyota Alphard",
                1500000));

        controller.jalankan();
    }
}
