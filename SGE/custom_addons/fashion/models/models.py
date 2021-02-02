# -*- coding: utf-8 -*-

from odoo import models, fields, api

## Modelo que crea los campos que utilizaremos para añadir informacion a la ventana fashion
class fashion(models.Model):
    _name = 'fashion.fashion'
    _description = 'fashion.fashion'

## Modelo que crea los campos que utilizaremos para añadir informacion a la ventana de seasson
class seasson(models.Model):
    _name = 'seassons.template'
    _description = 'seassons.template'

    name = fields.Char(string="Name", required=True)
    startDate = fields.Date('Start date', required=True, default=fields.Date.today())
    endDate = fields.Date('End date')