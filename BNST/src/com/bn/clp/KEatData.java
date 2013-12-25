package com.bn.clp;
import static com.bn.clp.Constant.*;

//可吃物体的数据类
public class KEatData
{
	//新添加的，可以吃掉物件的列表
	static float[][] KEAT_ARRAY=new float[][]
    {
		//2-4//吃了增加氮气的   弯道6
		{1, UNIT_SIZE*4-5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*2-20f, 0, 2, 4},
		{0, UNIT_SIZE*4, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*2-20f, 0, 2, 4},
		{1, UNIT_SIZE*4+5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*2-20f, 0, 2, 4},
		//2-8//吃了减速   弯道5
		{0, UNIT_SIZE*8, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*2+25f, 0, 2, 8},
		{1, UNIT_SIZE*8, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*2+20f, 0, 2, 8},
		{0, UNIT_SIZE*8, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*2+15f, 0, 2, 8},
		//3-9//吃了减速   弯道7
		{0, UNIT_SIZE*9, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*3-25f, 0, 3, 9},
		{0, UNIT_SIZE*9, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*3-20f, 0, 3, 9},
		{1, UNIT_SIZE*9, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*3-15f, 0, 3, 9},
		//2-15//吃了增加氮气的  弯道5
		{0, UNIT_SIZE*15, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*2+25f, 0, 2, 15},
		{1, UNIT_SIZE*15, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*2+20f, 0, 2, 15},
		{1, UNIT_SIZE*15, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*2+15f, 0, 2, 15},
		//7-11 吃了加速  弯道6
		{1, UNIT_SIZE*11-5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*7-20f, 0, 7, 11},
		{0, UNIT_SIZE*11, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*7-20f, 0, 7, 11},
		{0, UNIT_SIZE*11+5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*7-20f, 0, 7, 11},
		//13-11 吃了减速  弯道6
		{1, UNIT_SIZE*11-5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*13-20f, 0, 13, 11},
		{1, UNIT_SIZE*11, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*13-20f, 0, 13, 11},
		{1, UNIT_SIZE*11+5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*13-20f, 0, 13, 11},
		//12-13  吃了加速  弯道5
		{0, UNIT_SIZE*13, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*12+25f, 0, 12, 13},
		{1, UNIT_SIZE*13, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*12+20f, 0, 12, 13},
		{0, UNIT_SIZE*13, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*12+15f, 0, 12, 13},
		//12-20 吃了加速  弯道7
		{1, UNIT_SIZE*20-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*12-23f, 0, 12, 20},
		{0, UNIT_SIZE*20, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*12-20f, 0, 12, 20},
		{1, UNIT_SIZE*20+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*12-17f, 0, 12, 20},
		//7-21 吃了减速  弯道5
		{1, UNIT_SIZE*21, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*7+25f, 0, 7, 21},
		{0, UNIT_SIZE*21, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*7+20f, 0, 7, 21},
		{1, UNIT_SIZE*21, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*7+15f, 0, 7, 21},
		//4-21 吃了加速  弯道5
		{0, UNIT_SIZE*21, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*4+25f, 0, 4, 21},
		{0, UNIT_SIZE*21, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*4+20f, 0, 4, 21},
		{0, UNIT_SIZE*21, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*4+15f, 0, 4, 21},
		//6-28 吃了加速  弯道7
		{0, UNIT_SIZE*28-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*6-23f, 0, 6, 28},
		{1, UNIT_SIZE*28, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*6-20f, 0, 6, 28},
		{0, UNIT_SIZE*28+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*6-17f, 0, 6, 28},
		//12-26 吃了加速  弯道7
		{1, UNIT_SIZE*26-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*12-23f, 0, 12, 26},
		{0, UNIT_SIZE*26, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*12-20f, 0, 12, 26},
		{0, UNIT_SIZE*26+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*12-17f, 0, 12, 26},
		//19-25 吃了减速  弯道6
		{1, UNIT_SIZE*25-5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*19-20f, 0, 19, 25},
		{0, UNIT_SIZE*25, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*19-20f, 0, 19, 25},
		{1, UNIT_SIZE*25+5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*19-20f, 0, 19, 25},
		//28-23 吃了加速  弯道5
		{0, UNIT_SIZE*23, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*28+25f, 0, 28, 23},
		{0, UNIT_SIZE*23, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*28+20f, 0, 28, 23},
		{1, UNIT_SIZE*23, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*28+15f, 0, 28, 23},
		//29-21 吃了减速  弯道6
		{1, UNIT_SIZE*21-5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*29-20f, 0, 29, 21},
		{1, UNIT_SIZE*21, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*29-20f, 0, 29, 21},
		{0, UNIT_SIZE*21+5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*29-20f, 0, 29, 21},
		//28-19 吃了加速  弯道5
		{0, UNIT_SIZE*19, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*28+25f, 0, 28, 19},
		{0, UNIT_SIZE*19, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*28+20f, 0, 28, 19},
		{1, UNIT_SIZE*19, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*28+15f, 0, 28, 19},
		//20-16 吃了加速  弯道5
		{0, UNIT_SIZE*16, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*20-25f, 0, 20, 16},
		{1, UNIT_SIZE*16, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*20-20f, 0, 20, 16},
		{0, UNIT_SIZE*16, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*20-15f, 0, 20, 16},
		//23-11 吃了减速  弯道7
		{1, UNIT_SIZE*11-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*3-23f, 0, 23, 11},
		{0, UNIT_SIZE*11, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*3-20f, 0, 23, 11},
		{1, UNIT_SIZE*11+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*3-17f, 0, 23, 11},
		//27-9 吃了减速  弯道7
		{0, UNIT_SIZE*9-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*27-23f, 0, 27, 9},
		{1, UNIT_SIZE*9, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*27-20f, 0, 27, 9},
		{1, UNIT_SIZE*9+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*27-17f, 0, 27, 9},
		//28-6 吃了减速  弯道4
		{1, UNIT_SIZE*6+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*28+23f, 0, 28, 6},
		{1, UNIT_SIZE*6, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*28+20f, 0, 28, 6},
		{0, UNIT_SIZE*6-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*28+17f, 0, 28, 6},
		//26-1 吃了加速  弯道6
		{0, UNIT_SIZE*1-5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*26-20f, 0, 26, 1},
		{0, UNIT_SIZE*1, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*26-20f, 0, 26, 1},
		{1, UNIT_SIZE*1+5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*26-20f, 0, 26, 1},
		//25-2 吃了加速   弯道7
		{0, UNIT_SIZE*2-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*25-23f, 0, 25, 2},
		{1, UNIT_SIZE*2, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*25-20f, 0, 25, 2},
		{0, UNIT_SIZE*2+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*25-17f, 0, 25, 2},
		//18-2 吃了减速   弯道5
		{1, UNIT_SIZE*2, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*18+25f, 0, 18, 2},
		{0, UNIT_SIZE*2, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*18+20f, 0, 18, 2},
		{0, UNIT_SIZE*2, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*18+15f, 0, 18, 2},
		//18-1 吃了加速   弯道6 
		{0, UNIT_SIZE*1-5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*18-20f, 0, 18, 1},
		{1, UNIT_SIZE*1, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*18-20f, 0, 18, 1}, 
		{0, UNIT_SIZE*1+5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*18-20f, 0, 18, 1},
		//14-1 吃了减速   弯道6
		{1, UNIT_SIZE*1-5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*14-20f, 0, 14, 1},
		{0, UNIT_SIZE*1, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*14-20f, 0, 14, 1},
		{1, UNIT_SIZE*1+5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*14-20f, 0, 14, 1},
		//13-2 吃了加速   弯道7
		{1, UNIT_SIZE*2-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*13-23f, 0, 13, 2},
		{0, UNIT_SIZE*2, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*13-20f, 0, 13, 2},
		{0, UNIT_SIZE*2+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*13-17f, 0, 13, 2},
		//新添加的
		//4-15 吃了加速  弯道7
		{0, UNIT_SIZE*15-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*4-23f, 0, 4, 15},
		{1, UNIT_SIZE*15, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*4-20f, 0, 4, 15},
		{0, UNIT_SIZE*15+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*4-17f, 0, 4, 15},
		//4-11吃了减速  弯道4
		{1, UNIT_SIZE*11+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*4+23f, 0, 4, 11},
		{1, UNIT_SIZE*11, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*4+20f, 0, 4, 11},
		{0, UNIT_SIZE*11-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*4+17f, 0, 4, 11},
		//9-12吃了加速  弯道7
		{0, UNIT_SIZE*12-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*9-23f, 0, 9, 12},
		{1, UNIT_SIZE*12, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*9-20f, 0, 9, 12},
		{0, UNIT_SIZE*12+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*9-17f, 0, 9, 12},
		//14-15 吃了减速   弯道6
		{1, UNIT_SIZE*15-5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*14-20f, 0, 14, 15},
		{0, UNIT_SIZE*15, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*14-20f, 0, 14, 15},
		{1, UNIT_SIZE*15+5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*14-20f, 0, 14, 15},
		//13-19吃了加速  弯道7
		{0, UNIT_SIZE*19-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*13-23f, 0, 13, 19},
		{1, UNIT_SIZE*19, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*13-20f, 0, 13, 19},
		{0, UNIT_SIZE*19+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*13-17f, 0, 13, 19},
		//5-25吃了加速  弯道7
		{0, UNIT_SIZE*25-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*5-23f, 0, 5, 25},
		{1, UNIT_SIZE*25, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*5-20f, 0, 5, 25},
		{0, UNIT_SIZE*25+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*5-17f, 0, 5, 25},
		//2-25吃了减速  弯道4
		{1, UNIT_SIZE*25+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*2+23f, 0, 2, 25},
		{1, UNIT_SIZE*25, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*2+20f, 0, 2, 25},
		{0, UNIT_SIZE*25-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*2+17f, 0, 2, 25},
		//2-29吃了减速   弯道5
		{1, UNIT_SIZE*29, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*2+25f, 0, 2, 29},
		{0, UNIT_SIZE*29, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*2+20f, 0, 2, 29},
		{0, UNIT_SIZE*29, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*2+15f, 0, 2, 29},
		//10-27吃了减速   弯道5
		{1, UNIT_SIZE*27, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*10+25f, 0, 10, 27},
		{0, UNIT_SIZE*27, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*10+20f, 0, 10, 27},
		{0, UNIT_SIZE*27, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*10+15f, 0, 10, 27},
		//15-25 吃了减速   弯道6
		{1, UNIT_SIZE*25-5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*15-20f, 0, 15, 25},
		{0, UNIT_SIZE*25, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*15-20f, 0, 15, 25},
		{1, UNIT_SIZE*25+5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*15-20f, 0, 15, 25},
		//17-26吃了加速  弯道7
		{0, UNIT_SIZE*26-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*17-23f, 0, 17, 26},
		{1, UNIT_SIZE*26, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*17-20f, 0, 17, 26},
		{0, UNIT_SIZE*26+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*17-17f, 0, 17, 26},
		//23-26吃了加速  弯道7
		{0, UNIT_SIZE*26-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*23-23f, 0, 23, 26},
		{1, UNIT_SIZE*26, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*23-20f, 0, 23, 26},
		{0, UNIT_SIZE*26+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*23-17f, 0, 23, 26},
		//21-25吃了减速   弯道5
		{1, UNIT_SIZE*25, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*21+25f, 0, 21, 25},
		{0, UNIT_SIZE*25, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*21+20f, 0, 21, 25},
		{0, UNIT_SIZE*25, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*21+15f, 0, 21, 25},
		//26-25吃了加速  弯道7
		{0, UNIT_SIZE*25-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*26-23f, 0, 26, 25},
		{1, UNIT_SIZE*25, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*26-20f, 0, 26, 25},
		{0, UNIT_SIZE*25+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*26-17f, 0, 26, 25},
		//29-24吃了加速  弯道7
		{0, UNIT_SIZE*24-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*29-23f, 0, 29, 24},
		{1, UNIT_SIZE*24, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*29-20f, 0, 29, 24},
		{0, UNIT_SIZE*24+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*29-17f, 0, 29, 24},
		//28-15 吃了减速   弯道6
		{1, UNIT_SIZE*15-5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*28-20f, 0, 28, 15},
		{0, UNIT_SIZE*15, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*28-20f, 0, 28, 15},
		{1, UNIT_SIZE*15+5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*28-20f, 0, 28, 15},
		//24-16吃了加速  弯道7
		{0, UNIT_SIZE*16-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*24-23f, 0, 24, 16},
		{1, UNIT_SIZE*16, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*24-20f, 0, 24, 16},
		{0, UNIT_SIZE*16+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*24-17f, 0, 24, 16},
		//20-11吃了减速  弯道4
		{1, UNIT_SIZE*11+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*20+23f, 0, 20, 11},
		{1, UNIT_SIZE*11, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*20+20f, 0, 20, 11},
		{0, UNIT_SIZE*11-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*20+17f, 0, 20, 11},
		//29-2 吃了减速   弯道6
		{1, UNIT_SIZE*2-5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*29-20f, 0, 29, 2},
		{0, UNIT_SIZE*2, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*29-20f, 0, 29, 2},
		{1, UNIT_SIZE*2+5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*29-20f, 0, 29, 2},
		//22-3吃了减速   弯道5
		{1, UNIT_SIZE*3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*22+25f, 0, 22, 3},
		{0, UNIT_SIZE*3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*22+20f, 0, 22, 3},
		{0, UNIT_SIZE*3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*22+15f, 0, 22, 3},
		//21-1 吃了减速   弯道6
		{1, UNIT_SIZE*1-5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*21-20f, 0, 21, 1},
		{0, UNIT_SIZE*1, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*21-20f, 0, 21, 1},
		{1, UNIT_SIZE*1+5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*21-20f, 0, 21, 1},
		//8-3吃了加速  弯道7
		{0, UNIT_SIZE*3-3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*8-23f, 0, 8, 3},
		{1, UNIT_SIZE*3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*8-20f, 0, 8, 3},
		{0, UNIT_SIZE*3+3, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*8-17f, 0, 8, 3},
		//7-2 吃了减速   弯道6
		{1, UNIT_SIZE*2-5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*7-20f, 0, 7, 2},
		{0, UNIT_SIZE*2, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*7-20f, 0, 7, 2},
		{1, UNIT_SIZE*2+5, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*7-20f, 0, 7, 2},
		//3-2吃了减速   弯道5
		{1, UNIT_SIZE*2, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*3+25f, 0, 3, 2},
		{0, UNIT_SIZE*2, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*3+20f, 0, 3, 2},
		{0, UNIT_SIZE*2, WATER_HIGH_ADJUST+2.0f, UNIT_SIZE*3+15f, 0, 3, 2},
    };
}