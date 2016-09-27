<?php

namespace App\Model;

use Illuminate\Database\Eloquent\Model;
use DB;

class Record extends Model
{
    protected $table = 'records';

    protected $fillable = [
        'user',
        'content',
        'amount',
        'type',
        'date',
        'location',
        'category'
    ];


    /**
     * 获取所有消费记录
     *
     * @param int $userID
     * @return mixed
     */
    public function getAll($userID = 0)
    {
        $records = DB::table($this->table)
            ->where('user', $userID)
            ->get();

        return $records;
    }


}
