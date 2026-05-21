import java.util.Scanner;

public class ArenaPertarungan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Musuh[] gelombangMonster = new Musuh[4];
        gelombangMonster[0] = new Slime();
        gelombangMonster[1] = new Naga();
        gelombangMonster[2] = new Slime();
        gelombangMonster[3] = new Zombie();

        System.out.println("\n=====================================");
        System.out.println("   ARENA RPG: GELOMBANG MONSTER ");
        System.out.println("=====================================");
        System.out.println("AWAS! Sekelompok monster menghadang Anda!");

        boolean isBermain = true;

        while (isBermain) {
            System.out.println("\n------ STATUS MONSTER ------ ");

            for (int i = 0; i < gelombangMonster.length; i++) {
                if (gelombangMonster[i].healthPoint > 0) {
                    System.out.println((i + 1) + ". " + gelombangMonster[i].namaMusuh + " (HP: " + gelombangMonster[i].healthPoint + ")");
                } else {
                    System.out.println((i + 1) + ". " + gelombangMonster[i].namaMusuh + " [DEAD]");
                }
            }
            System.out.println("5. KABUR");
            System.out.print("\nCepet pilih monster yg mau lu serang (1/2/3/4) atau 5 untuk orang cupu: ");

            try {
            int pilihanTarget = input.nextInt();

            if (pilihanTarget == 5) {
                System.out.println("Cupu bet lu lari terbirit-birit");
                isBermain = false;
                continue;
            }

            if (pilihanTarget < 1 || pilihanTarget > 4) {
                System.out.println("LIHAT bener-bener ANGKA nya :D");
                continue;
            }
            
            int indeksMonster = pilihanTarget -1;

            if (gelombangMonster[indeksMonster].healthPoint <= 0) {
                throw new TargetMatiException(
            "Monsternya dah MATI KOCAK!"
                );
            }

                System.out.print("Masukin kekuatan serangan lu (10 - 100): ");
                int power = input.nextInt();

                if (power < 10 || power > 100) {
                    throw new SeranganTidakValidException("-literasi ya, HARUS (10-100)!!!");
                }

                System.out.println("\n>>> HASIL SERANGAN ANDA <<<");
                gelombangMonster[indeksMonster].terimaDamage(power);

                if (gelombangMonster[indeksMonster].healthPoint <= 0) {
                    System.out.println(gelombangMonster[indeksMonster].namaMusuh + " dah MATI!");
                    if (gelombangMonster[indeksMonster] instanceof DropItem) {
                        DropItem monsterLoot = (DropItem) gelombangMonster[indeksMonster];
                        monsterLoot.dropItem();
                    }
                }
            System.out.println("\n<<< GILIRAN MONSTER MEMBALAS >>>");

            for (int i = 0; i < gelombangMonster.length; i++) {
                if (gelombangMonster[i].healthPoint > 0) {
                    Musuh monsterAktif = gelombangMonster[i];
                    monsterAktif.suaraKhas();

                    if (monsterAktif instanceof BisaTerbang) {
                        System.out.println("[PERINGATAN! SERANGAN UDARA TERDETEKSI]");
                        BisaTerbang monsterTerbang = (BisaTerbang) monsterAktif;
                        monsterTerbang.lepasLandas();
                        monsterTerbang.seranganUdara();
                    } else {
                        monsterAktif.serangPemain();
                    }
                }
            }
            System.out.println("\n-----------------------------------------------------------------------------");

        } catch (java.util.InputMismatchException e) {
            System.out.println("ERROR INPUT: memasukkin ANGKA!!!");
            input.nextLine();
        }

        catch (TargetMatiException e) {
            System.out.println("KESALAHAN GAME: " + e.getMessage());
        }

        catch (SeranganTidakValidException e) {
            System.out.println("Tindakan Ilegal: " + e.getMessage() + "\n");
        }

        catch (Exception e) {
            System.out.println("Terjadi kesalahan sistem: " + e.getMessage());
        }
    }           

        boolean semuaMati = true;
        for (int i = 0; i < gelombangMonster.length; i++) {
            if (gelombangMonster[i].healthPoint > 0) {
                semuaMati = false;
                break;
            }
        }

        if (semuaMati) {
            System.out.println("\nya ya congrats, lu menang.");
            isBermain = false;
        }
        
        input.close();
        System.out.println("\nGame Over.");
    }
}