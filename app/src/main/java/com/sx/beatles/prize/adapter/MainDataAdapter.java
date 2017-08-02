package com.sx.beatles.prize.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.sx.beatles.prize.R;
import com.sx.beatles.prize.base.ListBaseAdapter;
import com.sx.beatles.prize.base.SuperViewHolder;
import com.sx.beatles.prize.bean.Prize;

/**
 * Created by 施行 on 2017/8/1.
 */
public class MainDataAdapter extends ListBaseAdapter<Prize> {
    private Context mContext;
    public MainDataAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_main_data_item;
    }

    @Override
    public void onBindItemHolder(SuperViewHolder holder, int position) {
        Prize prize = mDataList.get(position);

        TextView expect = holder.getView(R.id.prize_expect);
        TextView time = holder.getView(R.id.prize_time);

        TextView number1 = holder.getView(R.id.prize_number_1);
        TextView number2 = holder.getView(R.id.prize_number_2);
        TextView number3 = holder.getView(R.id.prize_number_3);
        TextView number4 = holder.getView(R.id.prize_number_4);
        TextView number5 = holder.getView(R.id.prize_number_5);
        TextView number6 = holder.getView(R.id.prize_number_6);
        TextView number7 = holder.getView(R.id.prize_number_7);

        String expectStr = mContext.getResources().getString(R.string.expect);
        String formatExpect = String.format(expectStr,prize.getExpect());
        time.setText(prize.getOpentime());
        expect.setText(formatExpect);
        //char [] chars = prizeInfo.getPrizeNumber().toCharArray();
        //if(chars.length < 7) return;

        String [] prizeNumber = prize.getOpencode().split(",");
        if(prizeNumber == null || prizeNumber.length < 7){
            Log.e("tyb","prizeNumber为空或者元素小于7");
            return;
        }
        number1.setText(prizeNumber[0]);
        number2.setText(prizeNumber[1]);
        number3.setText(prizeNumber[2]);
        number4.setText(prizeNumber[3]);
        number5.setText(prizeNumber[4]);
        number6.setText(prizeNumber[5]);
        number7.setText(prizeNumber[6]);

    }
}
