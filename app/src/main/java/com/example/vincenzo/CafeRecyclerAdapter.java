package com.example.vincenzo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class CafeRecyclerAdapter extends RecyclerView.Adapter<CafeRecyclerAdapter.ItemViewHolder> {

    ArrayList<cafe> cafeList = new ArrayList<cafe>();
    private TextView textView1, textView2;
    private ImageView ImageView1, ImageView2;
    private Context mContext;
    private Frag1_1 frag1_1 = new Frag1_1();

    public Double rush_ratio;
    public int rush_level;

    public CafeRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int position) {
        itemViewHolder.onBind(cafeList.get(position));
        itemViewHolder.setIsRecyclable(false);

    }

    @Override
    public int getItemCount() {
        return cafeList.size();
    }

    public void clearAllItems() {
        cafeList.clear();
    }

    public void addItem(cafe cafe) {
        cafeList.add(cafe);
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.textView1);
            ImageView1 = itemView.findViewById(R.id.ImageTest);
            textView2 = itemView.findViewById(R.id.stringdistance);
            ImageView2 = itemView.findViewById(R.id.rush_icon);

            itemView.setClickable(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Intent intent = new Intent(mContext, second_activity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("name", cafeList.get(pos).getName());
                        intent.putExtra("address", cafeList.get(pos).getAddress());
                        intent.putExtra("latitude", cafeList.get(pos).getLatitude());
                        intent.putExtra("longitude", cafeList.get(pos).getLongitude());
                        intent.putExtra("rush_level", cafeList.get(pos).getRushLevel());
                        intent.putExtra("rush_ratio", cafeList.get(pos).getRushRatio());

                        mContext.startActivity(intent);
                    }
                }
            });

        }


        // ?????? ???????????? 1?????? ???????????? 1:1 ???????????? ??????????????????.
        void onBind(cafe cafe) {

            CafeImageList List = new CafeImageList();
            String name = cafe.getName();
            int imageId = (int) (Math.random() * 5);

            GpsTracker gpsTracker = new GpsTracker(mContext);

            Location myLocation = new Location("point A");
            Location cafeLocation = new Location("point B");
            myLocation.setLatitude(gpsTracker.getLatitude());
            myLocation.setLongitude(gpsTracker.getLongitude());
            cafeLocation.setLatitude(cafe.getLatitude());
            cafeLocation.setLongitude(cafe.getLongitude());


            String distance = String.format("%.0f",myLocation.distanceTo(cafeLocation));
                Double dTemp = Double.parseDouble(distance);
                if(dTemp >= 1000){
                    distance = String.format("%.2f",myLocation.distanceTo(cafeLocation)/1000) + "km";
                }
                else{
                    distance = String.format("%.0f",myLocation.distanceTo(cafeLocation)) + "m";
                }

            int rush_level = cafe.getRushLevel();


            if (name.equals("?????????????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.starbucks.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("?????????????????????????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.agreat.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("??????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.bbobba.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("?????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.flanel.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.hyoidabang.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.bonsol.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("???????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.ilmio.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("??????????????????(?????????)")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.twosome.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("?????????????????? ?????????????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.twosome.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("?????? ??????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.cafepumda.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("????????????(????????????)")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.touslesjours.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("???????????????????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.coffenamu.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("??????(?????????)")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.chayam.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.nangman.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("???????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.sulbing.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("??????????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.baglefactory.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("?????????????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.nolsup.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("???????????????merci")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.merci.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("???????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.cafecubano.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("????????????(dear fine)")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.dearfine.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("??????(MOMONG)")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.momong.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("????????????????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.waffleden.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("????????????(Redwood)")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.redwood.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("??????????????????????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.caffeinejungdok.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("???????????? ???????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.bebridge.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("?????????????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.gongcha.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("?????????????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.nerd.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("???????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.cheongpadongcoffee.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("????????????????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.masigeuraei.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("?????????????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.brewda.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("???????????????????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.caphecozy.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.storyone.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("??????????????????????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.ediya.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("??????????????????????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.delicioussand.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("??????????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.blackbird.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("???????????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.eggmasissda.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("?????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.etccoffee.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else if (name.equals("?????????")) {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(List.yozit.get(imageId));
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            } else {
                textView1.setText(cafe.getName());
                ImageView1.setBackgroundResource(R.drawable.shop1);
                textView2.setText(distance);
                if (rush_level==1) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel1);
                } else if (rush_level==2) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel2);
                } else if (rush_level==3) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel3);
                } else if (rush_level==4) {
                    ImageView2.setBackgroundResource(R.drawable.ic_grouplevel4);
                } else {
                    ImageView2.setBackgroundResource(R.drawable.ic_colorchange);
                }
            }


//            textView1.setText(cafe.getName());
//            ImageView1.setBackgroundResource(listResId.get(imageId));

//            textView2.setText(cafe.getName());
//            ImageView2.setBackgroundResource(listResId2.get(imageId2));

//            textView2.setText(cafe.getAddress());
//            textView3.setText(cafe.getSize());
//            textView4.setText(cafe.getLatitude());
//            textView5.setText(cafe.getLongitude());
            // Glide URL??? ????????? ???????????? ????????????


        }

    }

}