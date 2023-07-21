package com.example.doodlecraft

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get

class MainActivity : AppCompatActivity() {

    private var drawingView: DrawingView? = null
    private var mImageButtonCurrentPaint : ImageButton? = null

    private var ivBackground : ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawingView = findViewById(R.id.drawing_view)
        drawingView?.setSizeForBrush(10.toFloat())

        val linearLayoutPaintColour = findViewById<LinearLayout>(R.id.ll_paint_colours)
        mImageButtonCurrentPaint = linearLayoutPaintColour[0] as ImageButton
        mImageButtonCurrentPaint?.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.pallet_pressed
            )
        )
        val ibBrush: ImageButton = findViewById(R.id.ib_brush)
        ibBrush.setOnClickListener {
            showBrushSizeChooserDialog()
        }

        val ibGallery:ImageButton = findViewById(R.id.ib_gallery)
        ibGallery.setOnClickListener{
            showBackgroundImageChooserDialog()
        }

        val ibUndo: ImageButton = findViewById(R.id.ib_undo)
        ibUndo.setOnClickListener {
            drawingView?.onClickUndo()
        }

    }

    private fun showBackgroundImageChooserDialog() {

        val imageDialog = Dialog(this)
        imageDialog.setContentView(R.layout.dialog_bg_images)
        imageDialog.setTitle("Choose Background: ")

        ivBackground = findViewById(R.id.iv_background)

        val bgImage1:ImageButton = imageDialog.findViewById(R.id.img1)
        bgImage1.setOnClickListener{
            ivBackground!!.setBackground(getDrawable(R.drawable.dog1))
            imageDialog.dismiss()
        }

        val bgImage2:ImageButton = imageDialog.findViewById(R.id.img2)
        bgImage2.setOnClickListener{
            ivBackground!!.setBackground(getDrawable(R.drawable.dog2))
            imageDialog.dismiss()
        }

        val bgImage3:ImageButton = imageDialog.findViewById(R.id.img3)
        bgImage3.setOnClickListener{
            ivBackground!!.setBackground(getDrawable(R.drawable.dog3))
            imageDialog.dismiss()
        }

        val bgImage4:ImageButton = imageDialog.findViewById(R.id.img4)
        bgImage4.setOnClickListener{
            ivBackground!!.setBackground(getDrawable(R.drawable.dog4))
            imageDialog.dismiss()
        }

        val bgImage5:ImageButton = imageDialog.findViewById(R.id.img5)
        bgImage5.setOnClickListener{
            ivBackground!!.setBackground(getDrawable(R.drawable.dog5))
            imageDialog.dismiss()
        }

        val bgImage6:ImageButton = imageDialog.findViewById(R.id.img6)
        bgImage6.setOnClickListener{
            ivBackground!!.setBackground(getDrawable(R.drawable.blank_page))
            imageDialog.dismiss()
        }



        imageDialog.show()
    }

    private fun showBrushSizeChooserDialog(){
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Brush Size: ")

        val smallBtn: ImageButton = brushDialog.findViewById(R.id.ib_small_brush)
        smallBtn.setOnClickListener(View.OnClickListener {
            drawingView?.setSizeForBrush(5.toFloat())
            brushDialog.dismiss()
        })
        val mediumBtn: ImageButton = brushDialog.findViewById(R.id.ib_medium_brush)
        mediumBtn.setOnClickListener(View.OnClickListener {
            drawingView?.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        })

        val largeBtn: ImageButton = brushDialog.findViewById(R.id.ib_large_brush)
        largeBtn.setOnClickListener(View.OnClickListener {
            drawingView?.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        })

        val extralargeBtn: ImageButton = brushDialog.findViewById(R.id.ib_extralarge_brush)
        extralargeBtn.setOnClickListener(View.OnClickListener {
            drawingView?.setSizeForBrush(25.toFloat())
            brushDialog.dismiss()
        })
        brushDialog.show()
    }

    fun paintClicked(view: View) {
        if (view !== mImageButtonCurrentPaint) {
            val imageButton = view as ImageButton
            val colorTag = imageButton.tag.toString()
            drawingView?.setColor(colorTag)
            imageButton.setImageDrawable(
                ContextCompat.getDrawable(
                    this, R.drawable.pallet_pressed
                )
            )
            mImageButtonCurrentPaint?.setImageDrawable(
                ContextCompat.getDrawable(
                    this, R.drawable.pallet_normal
                )
            )
            mImageButtonCurrentPaint = view
        }
    }
}