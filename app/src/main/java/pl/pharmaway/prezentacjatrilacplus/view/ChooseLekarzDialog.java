package pl.pharmaway.prezentacjatrilacplus.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.List;

import pl.pharmaway.prezentacjatrilacplus.Constants;
import pl.pharmaway.prezentacjatrilacplus.database.DataRow;
import pl.pharmaway.prezentacjatrilacplus.database.DatabaseHelper;

public class ChooseLekarzDialog extends ChooseElementDialog {

    private String lekarz;

    @Override
    public String getRowText(DataRow row) {
        return row.lekarz;
    }

    public static ChooseLekarzDialog create(
            String lekarz) {
        ChooseLekarzDialog dialog = new ChooseLekarzDialog();
        Bundle arguments = new Bundle();
        arguments.putString("lekarz", lekarz);
        dialog.setArguments(arguments);
        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        lekarz = getArguments().getString("lekarz");

        super.onCreate(savedInstanceState);
    }

    @Override
    public List<DataRow> getRows(Context context) {
        return DatabaseHelper.rowsForLekarzTypeAndAgent(Constants.LEKARZ_TYPE, lekarz, context);
    }

    @Override
    public void onRowSelected(DataRow row) {
        mLekarzDialogListener.onLekarzSelected(row.lekarz);
    }

    LekarzDialogListener mLekarzDialogListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof LekarzDialogListener) {
            mLekarzDialogListener = (LekarzDialogListener) context;
        } else {
            throw new RuntimeException(context.getClass().getSimpleName() + " must implement "
                    + LekarzDialogListener.class.getSimpleName());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mLekarzDialogListener = null;
    }

    public interface LekarzDialogListener {
        void onLekarzSelected(String city);
    }
}
