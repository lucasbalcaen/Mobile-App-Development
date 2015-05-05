package balcaen.lucas.be.mediamarktbelgium;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * Created by Lucas on 3/05/2015.
 */
public class KaartFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap googleMap;
    private static View view;
    private String naam;
    private String adres;
    private String huisnr;
    private String postcode;
    private String gemeente;
    private MapFragment mapFragment;
    private LatLng gegevens;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kaart_fragment, container, false);
        mapFragment = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getActivity() != null){
            Bundle bundle = getArguments();
            this.naam = bundle.getString(MainActivity.EXTRA_NAAM);
            this.adres = bundle.getString(MainActivity.EXTRA_ADRES);
            this.huisnr = bundle.getString(MainActivity.EXTRA_HUISNR);
            this.postcode = bundle.getString(MainActivity.EXTRA_POSTCODE);
            this.gemeente = bundle.getString(MainActivity.EXTRA_GEMEENTE);
        }

    }

    public static KaartFragment newInstance(String naam, String adres, String huisnr, String postcode, String gemeente)
    {
        KaartFragment kaartFragment = new KaartFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MainActivity.EXTRA_NAAM,naam);
        bundle.putString(MainActivity.EXTRA_ADRES,adres);
        bundle.putString(MainActivity.EXTRA_HUISNR,huisnr);
        bundle.putString(MainActivity.EXTRA_POSTCODE,postcode);
        bundle.putString(MainActivity.EXTRA_GEMEENTE,gemeente);
        kaartFragment.setArguments(bundle);
        return kaartFragment;
    }



    @Override
    public void onMapReady(GoogleMap map) {
        switch(naam){
            case "Media Markt Antwerpen": gegevens = new LatLng(51.2174195,4.4191892);
                break;
            case "Media Markt Hasselt": gegevens = new LatLng(50.925871,5.3290555);
                break;
            case "Media Markt Gosselies (Charleroi)": gegevens = new LatLng(50.4711344,4.4422734);
                break;
            case "Media Markt Liège": gegevens = new LatLng(50.6445879,5.5728208);
                break;
            case "Media Markt Jemappes (Bergen)": gegevens = new LatLng(50.44865,3.9034566);
                break;
            case "Media Markt Turnhout": gegevens = new LatLng(51.3130624,4.926729);
                break;
            case "Media Markt St-Pieters-Leeuw": gegevens = new LatLng(50.8034859,4.2886617);
                break;
            case "Media Markt Herstal": gegevens = new LatLng(50.6888049,5.6474235);
                break;
            case "Media Markt Schoten": gegevens = new LatLng(51.2679601,4.4636779);
                break;
            case "Media Markt Saturn Belgium": gegevens = new LatLng(50.889692,4.2621726);
                break;
            case "Media Markt Sint-Agatha-Berchem": gegevens = new LatLng(50.8717977,4.2954773);
                break;
            case "Media Markt Bruxelles": gegevens = new LatLng(50.8530098,4.3563241);
                break;
            case "Media Markt Roeselare": gegevens = new LatLng(50.9692023,3.1198816);
                break;
            case "Media Markt Oostende": gegevens = new LatLng(51.217102,2.8901248);
                break;
            case "Media Markt Sint-Lambrechts-Woluwe": gegevens = new LatLng(51.217102,2.8901248);
                break;
            default : gegevens = new LatLng(50.8246827,3.2514096);
                break;
        }

        LatLng sydney = new LatLng(-33.867, 151.206);

        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(gegevens, 13));

        map.addMarker(new MarkerOptions()
                .title(naam)
                .snippet(adres +" "+ huisnr)
                .position(gegevens));
    }

}
