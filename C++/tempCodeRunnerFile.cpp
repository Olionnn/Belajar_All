        cart = cart + pesan;

        //memasukan ke keranjang
        for (int i=0; i<cart; i++){
            idbrg[i] = nbrng[i];
        }
        for (int i=0; i<pesan; i++){
            idbrg[i + cart] = nbrng[i];
        }