<?php

namespace App\Model;

use Illuminate\Database\Eloquent\Model;
use DB;

class ToDoList extends Model
{
//    use QueryFactory;

    protected $table = 'to_do_list';

    protected $fillable = [
        'user_id',
        'content',
        'is_marked'
    ];


    public function getAllByUser($userID)
    {
        $toDoList = DB::table($this->table)
            ->where('user_id', $userID)
            ->get();
        return $toDoList;
    }


    public function getByUserIDAndContent($userID = 0, $content = '')
    {
        $toDoList = DB::table($this->table)
            ->where('user_id', $userID)
            ->where('content', $content)
            ->get();
        return $toDoList;
    }
}
