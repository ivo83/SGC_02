package ivant.example.com.sgc_02;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {


    public Toast toastFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toastFragment = Toast.makeText(getActivity(), "Method onCreate in WelcomeFragment executed.", Toast.LENGTH_SHORT);
        toastFragment.show();
        //start method ToToast();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        toastFragment = Toast.makeText(getActivity(), "Method onCreateView in WelcomeFragment executed.", Toast.LENGTH_SHORT);
        toastFragment.show();

        return inflater.inflate(R.layout.fragment_welcome, container, false);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        toastFragment = Toast.makeText(getActivity(), "Method onActivityCreated in WelcomeFragment executed.", Toast.LENGTH_SHORT);
        toastFragment.show();
        //start method ToToast();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        toastFragment = Toast.makeText(getActivity(), "Method onAttach in WelcomeFragment executed.", Toast.LENGTH_SHORT);
        toastFragment.show();
        //start method ToToast();
    }

    @Override
    public void onDetach() {
        super.onDetach();

        toastFragment = Toast.makeText(getActivity(), "Method onDetach in WelcomeFragment executed.", Toast.LENGTH_SHORT);
        toastFragment.show();
        //start method ToToast();
    }

    @Override
    public void onStart() {
        super.onStart();

        toastFragment = Toast.makeText(getActivity(), "Method onStart in WelcomeFragment executed.", Toast.LENGTH_SHORT);
        toastFragment.show();
        //start method ToToast();
    }

    @Override
    public void onStop() {
        super.onStop();

        toastFragment = Toast.makeText(getActivity(), "Method onStop in WelcomeFragment executed.", Toast.LENGTH_SHORT);
        toastFragment.show();
        //start method ToToast();
    }

    @Override
    public void onResume() {
        super.onResume();

        toastFragment = Toast.makeText(getActivity(), "Method onResume in WelcomeFragment executed.", Toast.LENGTH_SHORT);
        toastFragment.show();
        //start method ToToast();
    }

    @Override
    public void onPause() {
        super.onPause();
        toastFragment = Toast.makeText(getActivity(), "Method onPause in WelcomeFragment executed.", Toast.LENGTH_SHORT);
        toastFragment.show();
        //start method ToToast();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        toastFragment = Toast.makeText(getActivity(), "Method onDestroyView in WelcomeFragment executed.", Toast.LENGTH_SHORT);
        toastFragment.show();
        //start method ToToast();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        toastFragment = Toast.makeText(getActivity(), "Method onDestroy in WelcomeFragment executed.", Toast.LENGTH_SHORT);
        toastFragment.show();
        //start method ToToast();
    }

}
