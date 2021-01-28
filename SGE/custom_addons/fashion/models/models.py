# -*- coding: utf-8 -*-

from odoo import models, fields, api

class fashion(models.Model):
    _name = 'fashion.fashion'
    _description = 'fashion.fashion'
    
    # Campos
    name = fields.Char()
