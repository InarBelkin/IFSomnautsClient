package com.example.ifsomnauts.ui.world_story

import androidx.lifecycle.ViewModel

class WorldStoryViewModel : ViewModel() {
    public var changeCallback: ((Int) -> Unit)? = null;
}