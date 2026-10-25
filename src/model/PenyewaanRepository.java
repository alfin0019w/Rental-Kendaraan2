package model;
import java.util.List;

public interface PenyewaanRepository {
    String buatIBaru();
    void tambah(Penyewaan penyewaan);
    List<Penyewaan> semua();
    Penyewaan cariAktifByPlat(String platNomor);
}
