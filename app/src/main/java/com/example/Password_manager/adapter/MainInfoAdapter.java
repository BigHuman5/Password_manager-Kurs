package com.example.Password_manager.adapter;

import android.arch.lifecycle.LifecycleObserver;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Password_manager.Button.ButtonMainActivity;
import com.example.Password_manager.DataBase.ActionsWithBD;
import com.example.Password_manager.MainActivity;
import com.example.Password_manager.R;
import com.example.Password_manager.SettingsProject;
import com.example.Password_manager.StringsProject;
import com.example.Password_manager.category.parametersField;
import com.example.Password_manager.model.MainInfo;
import com.example.Password_manager.model.MainInformation;

import java.util.List;

public class MainInfoAdapter extends RecyclerView.Adapter<MainInfoAdapter.MainInfoViewHolder> implements LifecycleObserver {

    Context context;
    List<MainInfo> MainInfoList;
    List<MainInformation> mainInfoInformationList;
    StringsProject stringsProject;
    SettingsProject settingsProject;
    boolean work = false;
    int work1 = 0;

    public MainInfoAdapter(Context context, List<MainInfo> mainInfoList) {
        this.context = context;
        MainInfoList = mainInfoList;
    }

    @NonNull
    @Override
    public MainInfoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View MainInfoItems = LayoutInflater.from(context).inflate(R.layout.maininfo_content,viewGroup,false);
        return new MainInfoAdapter.MainInfoViewHolder(MainInfoItems);
    }

    @Override
    public void onBindViewHolder(@NonNull MainInfoViewHolder mainInfoViewHolder, int i) {
        settingsProject = new SettingsProject();
        int language = SettingsProject.getLanguage();
        stringsProject = new StringsProject(language);
        String visualProtectionText = "*****";
        int position = mainInfoViewHolder.getAdapterPosition();
        //MainActivity.getGetMainInfoRecycler().removeAllViews();
        //mainInfoViewHolder.img_content.setVisibility(View.VISIBLE);
        System.out.println(MainInfoList.get(i).getArg1()+" | "+MainInfoList.get(i).getType()+" | "+MainInfoList.get(i).getNameContent());
        switch (MainInfoList.get(i).getType())
        {
            case 0:{
                mainInfoViewHolder.img_content.setImageResource(R.drawable.ic_baseline_website_24);
                break;
            }
            case 1: {
                Context c = MainActivity.getContext();
                String nameRes = MainInfoList.get(i).getNameCategory().toLowerCase();
                System.out.println("nameRes: "+nameRes);
                int id = c.getResources().getIdentifier("drawable/"+nameRes, null, c.getPackageName());
                mainInfoViewHolder.img_content.setImageResource(id);
                break;
            }
            default:{
                mainInfoViewHolder.img_content.setImageResource(R.drawable.ic_baseline_website_24);
                break;
            }
        }

        System.out.println(position);
        mainInfoViewHolder.CardViewforInformation.setVisibility(View.GONE);

        mainInfoViewHolder.name_content.setText(MainInfoList.get(i).getNameContent());
        if(mainInfoViewHolder.CardViewforInformation.getVisibility() == View.VISIBLE)
        {
            mainInfoInformationList = ActionsWithBD.getListMainInformation(position); // Получение данных.
        }
        mainInfoViewHolder.button_close_or_open_content.setOnClickListener(new View.OnClickListener() {
            @Override
            //@OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            public void onClick(View v){
                mainInfoInformationList = ActionsWithBD.getListMainInformation(position);
                //
                parametersField parametersField = new parametersField(mainInfoInformationList.get(0).getType());
                boolean secure[] = parametersField.getSecureField();
                boolean copy[] = parametersField.getCopyField();
                System.out.println(position);

                if(mainInfoViewHolder.CardViewforInformation.getVisibility() == View.GONE)
                {
                    if(getWork1() != 0) notifyItemChanged(getWork1());
                    setWork1(position);

                    System.out.println("CLose");
                  mainInfoViewHolder.CardViewforInformation.setVisibility(View.VISIBLE);
                }
                else 
                {
                    setWork1(0);
                    notifyItemChanged(position,null);
                    System.out.println("Open");
                   mainInfoViewHolder.CardViewforInformation.setVisibility(View.GONE);
                }
                //
                mainInfoViewHolder.NameArg1.setText(mainInfoInformationList.get(0).getNameArg1());
                /*Обработка визуальной защиты данных*/
                if(secure[0])
                {
                    mainInfoViewHolder.Arg1.setText(visualProtectionText);
                }
                else
                {
                    mainInfoViewHolder.secure1.hide();
                    mainInfoViewHolder.Arg1.setText(mainInfoInformationList.get(0).getArg1());
                }
                //
                if(mainInfoInformationList.get(0).getArg2() != null)
                {
                    mainInfoViewHolder.NameArg2.setText(mainInfoInformationList.get(0).getNameArg2());
                    if(secure[1])
                    {
                        mainInfoViewHolder.Arg2.setText(visualProtectionText);
                    }
                    else
                    {
                        mainInfoViewHolder.secure2.hide();
                        mainInfoViewHolder.Arg2.setText(mainInfoInformationList.get(0).getArg2());
                    }
                }
                else mainInfoViewHolder.layout_Arg2.setVisibility(View.GONE);
                //
                if(mainInfoInformationList.get(0).getNameArg3() != null)
                {
                    mainInfoViewHolder.NameArg3.setText(mainInfoInformationList.get(0).getNameArg3());
                    if(secure[2])
                    {
                        mainInfoViewHolder.Arg3.setText(visualProtectionText);
                    }
                    else
                    {
                        mainInfoViewHolder.secure3.hide();
                        mainInfoViewHolder.Arg3.setText(mainInfoInformationList.get(0).getArg3());
                    }
                }
                else mainInfoViewHolder.layout_Arg3.setVisibility(View.GONE);
                //
                if(mainInfoInformationList.get(0).getArg4() != null)
                {
                    mainInfoViewHolder.NameArg4.setText(mainInfoInformationList.get(0).getNameArg4());
                    if(secure[3])
                    {
                        mainInfoViewHolder.Arg4.setText(visualProtectionText);
                    }
                    else
                    {
                        mainInfoViewHolder.secure4.hide();
                        mainInfoViewHolder.Arg4.setText(mainInfoInformationList.get(0).getArg4());
                    }
                }
                else mainInfoViewHolder.layout_Arg4.setVisibility(View.GONE);
                /*              */
                System.out.println("ARG2: "+mainInfoInformationList.get(0).getArg2()+" | "+secure[2]);
                System.out.println(mainInfoViewHolder.Arg1.getText());
                ButtonMainActivity.secure(mainInfoViewHolder,visualProtectionText,mainInfoInformationList);
            }

        });
    }

    @Override
    public int getItemCount() {
        return MainInfoList.size();
    }

    public static final class MainInfoViewHolder extends RecyclerView.ViewHolder
    {
        private ConstraintLayout constraintLayout;

        private View layout_Arg1;
        private View layout_Arg2;
        private  View layout_Arg3;
        private  View layout_Arg4;

        private FloatingActionButton button_close_or_open_content;
        private ImageView img_content;
        private TextView name_content;
        private FloatingActionButton more_info_about_content;
        private CardView CardViewforInformation;

        private TextView NameArg1;
        private TextView NameArg2;
        private TextView NameArg3;
        private TextView NameArg4;

        private TextView Arg1;
        private TextView Arg2;
        private TextView Arg3;
        private TextView Arg4;

        private FloatingActionButton secure1;
        private FloatingActionButton secure2;
        private FloatingActionButton secure3;
        private FloatingActionButton secure4;

        private FloatingActionButton copy1;
        private FloatingActionButton copy2;
        private FloatingActionButton copy3;
        private FloatingActionButton copy4;


        public MainInfoViewHolder(@NonNull View itemView) {
            super(itemView);

            constraintLayout = itemView.findViewById(R.id.InformationContent);

            layout_Arg1 = itemView.findViewById(R.id.layout_Arg1);
            layout_Arg2 = itemView.findViewById(R.id.layout_Arg2);
            layout_Arg3 = itemView.findViewById(R.id.layout_Arg3);
            layout_Arg4 = itemView.findViewById(R.id.layout_Arg4);

            button_close_or_open_content = itemView.findViewById(R.id.button_close_or_open_content);
            img_content = itemView.findViewById(R.id.MainInfo_imgContent);
            name_content = itemView.findViewById(R.id.name_category);

            more_info_about_content = itemView.findViewById(R.id.more_info_about_content);
            CardViewforInformation = itemView.findViewById(R.id.cardviewforinformation);

            NameArg1 = itemView.findViewById(R.id.arg1);
            NameArg2 = itemView.findViewById(R.id.arg2);
            NameArg3 = itemView.findViewById(R.id.arg3);
            NameArg4 = itemView.findViewById(R.id.arg4);

            Arg1 = itemView.findViewById(R.id.arg1_value);
            Arg2 = itemView.findViewById(R.id.arg2_value);
            Arg3 = itemView.findViewById(R.id.arg3_value);
            Arg4 = itemView.findViewById(R.id.arg4_value);

            secure1 = itemView.findViewById(R.id.secure1);
            secure2 = itemView.findViewById(R.id.secure2);
            secure3 = itemView.findViewById(R.id.secure3);
            secure4 = itemView.findViewById(R.id.secure4);

            copy1 = itemView.findViewById(R.id.copy1);
            copy2 = itemView.findViewById(R.id.copy2);
            copy3 = itemView.findViewById(R.id.copy3);
            copy4 = itemView.findViewById(R.id.copy4);

        }

        public View getConstraintLayout() {
            return constraintLayout;
        }

        public FloatingActionButton getButton_close_or_open_content() {
            return button_close_or_open_content;
        }

        public TextView getArg1() {
            return Arg1;
        }

        public TextView getArg2() {
            return Arg2;
        }

        public TextView getArg3() {
            return Arg3;
        }

        public TextView getArg4() {
            return Arg4;
        }

        public FloatingActionButton getSecure1() {
            return secure1;
        }

        public FloatingActionButton getSecure2() {
            return secure2;
        }

        public FloatingActionButton getSecure3() {
            return secure3;
        }

        public FloatingActionButton getSecure4() {
            return secure4;
        }

        public FloatingActionButton getCopy1() {
            return copy1;
        }

        public FloatingActionButton getCopy2() {
            return copy2;
        }

        public FloatingActionButton getCopy3() {
            return copy3;
        }

        public FloatingActionButton getCopy4() {
            return copy4;
        }
    }

    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    public int getWork1() {
        return work1;
    }

    public void setWork1(int work1) {
        this.work1 = work1;
    }
}

