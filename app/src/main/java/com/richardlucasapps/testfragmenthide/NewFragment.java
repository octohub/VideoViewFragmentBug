package com.richardlucasapps.testfragmenthide;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * A placeholder fragment containing a simple view.
 */
public class NewFragment extends Fragment {

    public NewFragment() {
    }

    public static NewFragment newInstance() {
        return new NewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        VideoView videoView = (VideoView) view.findViewById(R.id.video_view);
        videoView.setMediaController(new MediaController(getContext()));
        Uri video = Uri.parse("android.resource://" + getContext().getPackageName() + "/"
                + R.raw.video0);
        videoView.setVideoURI(video);
        videoView.start();
        //videoView.setZOrderMediaOverlay(true);
    }
}