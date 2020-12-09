package com.shahin.stream.mediaplayer

import com.google.android.exoplayer2.source.ShuffleOrder

class MediaShuffleOrder: ShuffleOrder {
    override fun getLength(): Int {
        TODO("Not yet implemented")
    }

    override fun getNextIndex(index: Int): Int {
        TODO("Not yet implemented")
    }

    override fun getPreviousIndex(index: Int): Int {
        TODO("Not yet implemented")
    }

    override fun getLastIndex(): Int {
        TODO("Not yet implemented")
    }

    override fun getFirstIndex(): Int {
        TODO("Not yet implemented")
    }

    override fun cloneAndInsert(insertionIndex: Int, insertionCount: Int): ShuffleOrder {
        TODO("Not yet implemented")
    }

    override fun cloneAndRemove(indexFrom: Int, indexToExclusive: Int): ShuffleOrder {
        TODO("Not yet implemented")
    }

    override fun cloneAndClear(): ShuffleOrder {
        TODO("Not yet implemented")
    }
}