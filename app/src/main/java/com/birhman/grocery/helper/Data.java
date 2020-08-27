package com.birhman.grocery.helper;

import com.birhman.grocery.model.Category;
import com.birhman.grocery.model.Offer;
import com.birhman.grocery.model.Product;
import com.birhman.grocery.model.ProductCategoryModel;
import com.birhman.grocery.model.StoreModel;

import java.util.ArrayList;
import java.util.List;

public class Data {
    List<Category> categoryList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();
    List<Product> newList = new ArrayList<>();
    List<Product> popularList = new ArrayList<>();
    List<Offer> offerList = new ArrayList<>();
    List<StoreModel> storeList = new ArrayList<>();
    List<ProductCategoryModel> productCategoryModels = new ArrayList<>();

    public List<Category> getCategoryList() {
        Category category = new Category("1", "Food", "https://image.flaticon.com/icons/png/512/262/262344.png");
        categoryList.add(category);
        category = new Category("2", "Home & Cleaning", "https://us.123rf.com/450wm/keltt/keltt1408/keltt140800001/30495344-stock-vector-blue-cleaning-house-icon-with-mop-and-bucket.jpg?ver=6");
        categoryList.add(category);
        category = new Category("3", "Baby Care", "https://tips4tots.files.wordpress.com/2015/08/medical-insurance-free-icon.png");
        categoryList.add(category);
        category = new Category("4", "Sports & Nutrition", "https://www.seekpng.com/png/detail/698-6989043_nutrition-icon.png");
        categoryList.add(category);
        category = new Category("5", "Pet care", "http://kasperstromman.files.wordpress.com/2013/05/dog-cat-above-board.jpg");
        categoryList.add(category);
        category = new Category("6", "Health & Household", "https://thumbs.dreamstime.com/b/household-cleaning-products-accessories-basket-there-mop-detergents-rubber-gloves-glass-cleaner-sponges-89944820.jpg");
        categoryList.add(category);
        return categoryList;
    }

    public List<ProductCategoryModel> getGroceryCatList() {
        ProductCategoryModel category = new ProductCategoryModel("1", "Dry Fruits", "https://5.imimg.com/data5/TE/UT/MY-925184/dry-fruits-and-nuts-testing-500x500.png");
        productCategoryModels.add(category);
        category = new ProductCategoryModel("2", "Fresh Fruits", "https://w7.pngwing.com/pngs/780/540/png-transparent-organic-food-meat-slicer-mandoline-peeler-fresh-fruits-and-vegetables-natural-foods-leaf-vegetable-food.png");
        productCategoryModels.add(category);
        category = new ProductCategoryModel("3", "Fresh Vegetables", "https://f0.pngfuel.com/png/909/529/fruit-and-vegetable-basket-png-clip-art-thumbnail.png");
        productCategoryModels.add(category);
        category = new ProductCategoryModel("4", "Fresh Herbs & Seasoning", "https://www.sylviasbasket.co.ke/wp-content/uploads/2018/11/thyme.jpg");
        productCategoryModels.add(category);
        category = new ProductCategoryModel("5", "Cuts & Sprouts", "https://grocery.opentestdrive.com/pub/media/catalog/product/cache/e819006f18c915980d42f53f1d376f57/c/u/cut_veg.png");
        productCategoryModels.add(category);
        category = new ProductCategoryModel("6", "Provisions", "https://www.konadugh.com/wp-content/uploads/2019/11/breakfast-Vertical-Menu.png");
        productCategoryModels.add(category);
        return productCategoryModels;
    }

    public List<ProductCategoryModel> getFoodCatList() {
        ProductCategoryModel category = new ProductCategoryModel("1", "Dairy Products", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcT22bMjW4q9_ZWwaZveKsTKkP3rMscuyXxYYA&usqp=CAU");
        productCategoryModels.add(category);
        category = new ProductCategoryModel("2", "Provisions", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRbiLLbg8xwwICnGfitXdDxOXDo0n4F3ZuqfA&usqp=CAU");
        productCategoryModels.add(category);
        category = new ProductCategoryModel("3", "Condiments", "https://bloximages.chicago2.vip.townnews.com/tctimes.com/content/tncms/assets/v3/editorial/7/12/71256a6a-4927-11e1-941e-0019bb2963f4/4f230c3ad7188.image.png");
        productCategoryModels.add(category);
        category = new ProductCategoryModel("4", "Instant Food & Ready to Eat", "https://aapkagrocery.com/wp-content/uploads/2020/06/Noodles-Sauces-Instant-Food.png");
        productCategoryModels.add(category);
        category = new ProductCategoryModel("5", "Beverages", "https://cdn.imgbin.com/17/4/11/imgbin-orange-juice-fizzy-drinks-smoothie-juice-dHMwKYCYSaN16KmEHWvYndeM9.jpg");
        productCategoryModels.add(category);
        category = new ProductCategoryModel("6", "Baby Care", "https://img.pngio.com/children-baby-maternity-industry-kids-exhibition-expo-events-baby-products-png-265_230.png");
        productCategoryModels.add(category);
        category = new ProductCategoryModel("7", "Chocolates & Ice- Cream", "https://png.pngtree.com/png-clipart/20190517/original/pngtree-realistic-chocolate-ice-cream-png-image_3598931.jpg");
        productCategoryModels.add(category);
        category = new ProductCategoryModel("8", "Paan", "https://sunshinysasite.files.wordpress.com/2019/01/paan-png-68472636464434058867.png");
        productCategoryModels.add(category);
        category = new ProductCategoryModel("9", "Snacks & Frozen Food", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQX8yfdGHuFZhbaT0BIvJKiLNsregaYY3Zm3g&usqp=CAU");
        productCategoryModels.add(category);
        category = new ProductCategoryModel("10", "Personal Care", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTPWyj-cIHdc1xaP3aAbLl6638zSqJDUiAlDA&usqp=CAU");
        productCategoryModels.add(category);
        return productCategoryModels;
    }

    public List<StoreModel> getStoreList() {
        StoreModel storeModel = new StoreModel("1", "JK Store",
                "https://beaforceofgood.files.wordpress.com/2015/08/indian-grocery.jpg",
                "4.2 km Moti Nagar", "15 mins");
        storeList.add(storeModel);
        storeModel = new StoreModel("2", "Grocers Store",
                "https://lh3.googleusercontent.com/proxy/K6ix_64VtzRdw3JSQNrUt9tilonzGM5MWDHxjIS2POfv_smkSi6ZVlHtSl025rLPLaMKvSmp-rbvWuo6oL1mbwYYePVcBQ-3mQhlNSBLwZmvItuBWCUWJD3hc_5U-EMC",
                "5 km Dwarka", "25 mins");
        storeList.add(storeModel);
        storeModel = new StoreModel("3", "Food Max Store",
                "https://www.pngkey.com/png/detail/84-847965_any-grocery-stores-7-day-advertised-price-supermarket.png",
                "5.6 km Rohini",
                "27 mins");
        storeList.add(storeModel);
        storeModel = new StoreModel("4", "Fresh Products Shopee",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQhCYJVqpkItVOKViF08NshGoEkfB6lI0X_2g&usqp=CAU",
                "4.2 km Kamla Nagar", " 15 mins");
        storeList.add(storeModel);
        storeModel = new StoreModel("5", "Modern Market",
                "https://3.imimg.com/data3/EU/IL/MY-14547142/pulses-250x250.png",
                "3.1 km Gurgaon", "20 mins");
        storeList.add(storeModel);
        storeModel = new StoreModel("6", "Geeta Store",
                "https://3.imimg.com/data3/IG/YM/MY-20509649/store-pulses-and-food-grains-250x250.jpg",
                "2.6 km Malviya Nagar", "10 mins");
        storeList.add(storeModel);
        storeModel = new StoreModel("7", "Mannu Store",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSYynD3PHXxovHfVe1xT64YQp-RnbrA0t-GZA&usqp=CAU",
                "3.5 Rajouri Garden", "20 mins");
        storeList.add(storeModel);
        storeModel = new StoreModel("8", "Santosh Dairy",
                "https://www.kindpng.com/picc/m/298-2983882_food-processing-industry-different-types-of-dairy-products.png",
                "4 km Vikaspuri", "20 mins");
        storeList.add(storeModel);
        storeModel = new StoreModel("9", "Ace Store",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR3xR1JsW9wkPibj5QHy9r5NBN4f_t4dOa6aA&usqp=CAU",
                "2 km RK Puram", "33 mins");
        storeList.add(storeModel);
        storeModel = new StoreModel("10", "Amit Super Market",
                "https://www.kindpng.com/picc/m/239-2399368_garam-masala-powder-png-transparent-png.png",
                "5.5 km Janakpuri", "30 mins");
        storeList.add(storeModel);
        return storeList;
    }

    public List<StoreModel> getFoodStoreList() {
        StoreModel storeModel = new StoreModel("1", "Fruits Store",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRWOxpvCIHueBRf38fnGQUQzJAF5St9evfHvQ&usqp=CAU",
                "3 km Dinpur", "25 mins");
        storeList.add(storeModel);
        storeModel = new StoreModel("2", "Modern Bazar",
                " https://i.dlpng.com/static/png/7079524_preview.png",
                "3.6 km Sarojini", "33 mins");
        storeList.add(storeModel);
        storeModel = new StoreModel("3", "Amit Store",
                "https://i7.pngguru.com/preview/205/18/532/basket-food-vegetable-grocery-store-desktop-wallpaper-fruit-and-vegetable.jpg",
                "4 km IIT",
                "30 mins");
        storeList.add(storeModel);
        storeModel = new StoreModel("4", "Kajal Store",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSqbZR4nwyP6MKTkOcG5ZbhU180hevUSXiBtQ&usqp=CAU",
                "3.6 km Delhi", " 29 mins");
        storeList.add(storeModel);
        storeModel = new StoreModel("5", "Fresh Products",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQxNi3Kw3sVKWktpgIEVUQdHXyBCdpRTTRvAA&usqp=CAU",
                "4 km Uttam Nagar", "26 mins");
        storeList.add(storeModel);
        storeModel = new StoreModel("6", "Arjun Fruits and Vegetables",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTAXQWWkHo4pQMEuKUijfyTHxmporuCg_8puw&usqp=CAU",
                "2.8 km Shadipur", "20 mins");
        storeList.add(storeModel);
        storeModel = new StoreModel("7", "Fresh Vegetables Store",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQmcufW617q4RQbHqwh64HkvL8sbMKRaiLPxQ&usqp=CAU",
        "5.7 km", "47 mins");
        storeList.add(storeModel);
        storeModel = new StoreModel("8", "Modern Market",
                "https://pic.pikbest.com/pikbest/pic/00/23/65/46i888piCBQh.jpg-0.jpg!bw340",
                "6 km Ashok Vihar", "44 mins");
        storeList.add(storeModel);
        storeModel = new StoreModel("9", "Fresh Fruits and Veggies",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTHV3K3qKyAVo8eMf1VLyMfefX7Ot1XEURe3A&usqp=CAU",
                "5.8 km Palam", "38 mins");
        storeList.add(storeModel);
        storeModel = new StoreModel("10", "Samar Fruits and Veggies",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR7opcG9LXdq2-ai3Ajo1h9Z_pFBxhVYxLD8Q&usqp=CAU",
                "4.8 km Palam", "28 mins");
        storeList.add(storeModel);
        return storeList;
    }

    public List<Category> getFoodCategoryList() {
        Category category = new Category("1", "Food", "https://image.flaticon.com/icons/png/512/262/262344.png");
        categoryList.add(category);
        category = new Category("2", "Drink", "https://lisasnatural.com/wp-content/uploads/2018/05/housecleanicon-300x228.jpg");
        categoryList.add(category);
        category = new Category("3", "Fast Food", "https://tips4tots.files.wordpress.com/2015/08/medical-insurance-free-icon.png");
        categoryList.add(category);
        category = new Category("4", "Pizza & Burger", "https://kathleenhalme.com/images/nutrition-clipart-sport.jpg");
        categoryList.add(category);
        category = new Category("5", "Hot Coffee", "http://kasperstromman.files.wordpress.com/2013/05/dog-cat-above-board.jpg");
        categoryList.add(category);
        category = new Category("6", "Non-Veg", "https://thumbs.dreamstime.com/b/household-cleaning-products-accessories-basket-there-mop-detergents-rubber-gloves-glass-cleaner-sponges-89944820.jpg");
        categoryList.add(category);
        return categoryList;
    }

    public List<Product> getProductList() {
        Product product = new Product("1", "1", "Apple", "", "1 Kg", "Rs.", "20", "10% OFF", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        productList.add(product);
        product = new Product("2", "1", "Banana", "", "1 Bounch", "Rs.", "10", "20% OFF", "https://images-na.ssl-images-amazon.com/images/I/21DejQuoT2L.jpg");
        productList.add(product);
        product = new Product("3", "2", "House Clean Liquid", "", "1 Lit.", "Rs.", "25", "", "https://images.freshop.com/00817939003794/f2e5a6d457412020e9b9cab838426a09_large.png");
        productList.add(product);
        product = new Product("4", "2", "House Clean Brush", "", "1 Piece", "Rs.", "10", "", "https://www.clean-hoouse.com/wp-content/uploads/2017/09/13.png");
        productList.add(product);
        product = new Product("5", "3", "Pampers", "", "1 Piece", "Rs.", "20", "10% OFF", "https://cdn.bmstores.co.uk/images/hpcProductImage/imgFull/311448-Pampers-Baby-Dry-Size-4-Maxi-251.jpg");
        productList.add(product);
        product = new Product("6", "3", "Baby Oil", "", "500 Ml", "Rs.", "31", "", "https://www.johnsonsbabyarabia.com/sites/jbaby_menap/files/product-images/johnsons-baby-regular-baby-oil-500ml.png");
        productList.add(product);
        product = new Product("7", "4", "Apple", "", "1 Kg", "Rs.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        productList.add(product);
        product = new Product("8", "4", "Apple", "", "1 Kg", "Rs.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        productList.add(product);
        product = new Product("9", "5", "Apple", "", "1 Kg",
                "Rs.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        productList.add(product);
        product = new Product("10", "5", "Apple", "", "1 Kg",
                "Rs.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        productList.add(product);
        product = new Product("11", "6", "Apple", "", "1 Kg",
                "Rs.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        productList.add(product);
        product = new Product("12", "6", "Apple", "", "1 Kg",
                "Rs.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        productList.add(product);
        product = new Product("13", "1", "Litche", "", "1 Kg",
                "Rs.", "20", "30%OFF", "https://cdn.shopify.com/s/files/1/0665/4989/products/lichee-485x400_grande.jpg");
        productList.add(product);
        return productList;
    }

    public List<Product> getNewList() {
        Product product = new Product("1", "1", "Apple", "",
                "1 Kg", "Rs.", "20", "10% OFF", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        newList.add(product);
        product = new Product("2", "1", "Banana", "",
                "1 Bounch", "Rs.", "10", "20% OFF", "https://images-na.ssl-images-amazon.com/images/I/21DejQuoT2L.jpg");
        newList.add(product);
        product = new Product("3", "2", "House Clean Liquid", "",
                "1 Lit.", "Rs.", "25", "", "http://sunsetcleaningcia.com/wp-content/uploads/2016/05/houseclean.png");
        newList.add(product);
        product = new Product("4", "2", "House Clean Brush", "",
                "1 Piece", "Rs.", "10", "", "https://www.clean-hoouse.com/wp-content/uploads/2017/09/13.png");
        newList.add(product);
        product = new Product("5", "3", "Pampers", "",
                "1 Piece", "20", "Rs.", "10% OFF", "https://cdn.bmstores.co.uk/images/hpcProductImage/imgFull/311448-Pampers-Baby-Dry-Size-4-Maxi-251.jpg");
        newList.add(product);
        return newList;
    }

    public List<Product> getPopularList() {
        Product product = new Product("6", "3", "Baby Oil", "",
                "500 Ml", "Rs.", "31", "", "https://www.fortunaonline.net/media/catalog/product/cache/1/small_image/295x/040ec09b1e35df139433887a97daa66f/n/k/nkbcp12_-_xia-shib-ao-baby-oil-200ml.png");
        popularList.add(product);
        product = new Product("7", "4", "Apple", "", "1 Kg",
                "Rs.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        popularList.add(product);
        product = new Product("8", "4", "Apple", "", "1 Kg",
                "Rs.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        popularList.add(product);
        product = new Product("9", "5", "Apple", "", "1 Kg",
                "Rs.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        popularList.add(product);
        product = new Product("10", "5", "Apple", "", "1 Kg",
                "Rs.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        popularList.add(product);
        product = new Product("11", "6", "Apple", "", "1 Kg",
                "Rs.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        popularList.add(product);
        product = new Product("12", "6", "Apple", "", "1 Kg",
                "Rs.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        popularList.add(product);
        product = new Product("13", "1", "Litche", "", "1 Kg",
                "Rs.", "20", "30%OFF", "https://cdn.shopify.com/s/files/1/0665/4989/products/lichee-485x400_grande.jpg");
        popularList.add(product);
        return popularList;
    }

    public List<Offer> getOfferList() {
        Offer offer = new Offer("http://1.bp.blogspot.com/-MMt-60IWEdw/VqZsh45Dv8I/AAAAAAAAMHg/70D9tVowlyc/s1600/askmegrocery-republic-day-offer.jpg");
        offerList.add(offer);
        offer = new Offer("http://www.lootkaro.com/wp-content/uploads/2016/05/as1.jpg");
        offerList.add(offer);
        offer = new Offer("https://453xbcknr3t3ahr522mms518-wpengine.netdna-ssl.com/wp-content/themes/iga-west/images/banner-save-more.jpg");
        offerList.add(offer);
        offer = new Offer("https://images-eu.ssl-images-amazon.com/images/G/31/img16/Grocery/SVD/July18/750x375.png");
        offerList.add(offer);
        offer = new Offer("https://images-eu.ssl-images-amazon.com/images/G/31/img16/Grocery/BreakfastStore/kmande_2018-06-15T12-00_f010a5_1121973_grocery_750x375.jpg");
        offerList.add(offer);
        offer = new Offer("http://www.enjoygrocery.com/images/enjoygrocery-offer.jpg");
        offerList.add(offer);


        return offerList;
    }
}
